package com.backend.demo.web.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.demo.domain.Services.DemoUserDetailService;
import com.backend.demo.web.controller.JwtFilterRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private DemoUserDetailService demoUserDetailService;
    @Autowired
    private JwtFilterRequest filterRequest;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.antMatchers("/**/demo/saludar","/**/login/autentificacion","/**/usuario/guardar").permitAll();
                    auth.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults()).addFilterBefore(filterRequest, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    
    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(demoUserDetailService)
        .passwordEncoder(bCryptPasswordEncoder)
        .and()
        .build();
    }
    
    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
