package com.backend.demo.web.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.demo.domain.Services.DemoUserDetailService;
import com.backend.demo.web.security.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter{

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private DemoUserDetailService demoUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        try{
            String authorizationHeader = request.getHeader("Authorization");
            if(authorizationHeader !=null && authorizationHeader.startsWith(("Bearer"))){
                String jwt = authorizationHeader.substring(7);
                    String username = jwtUtil.extractUser(jwt);
                    if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null){
                        UserDetails userDetails= demoUserDetailService.loadUserByUsername(username);
                        if (jwtUtil.validateToken(jwt,userDetails)){
                            UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                        }
                    }
             
            }
            filterChain.doFilter(request,response);
        }catch (ExpiredJwtException ex){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            final Map<String, Object> body = new HashMap<>();
            body.put("claims",ex.getClaims());
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(),body);
               
        }
    }
    
}
