package com.backend.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.domain.AuthenticationRequest;
import com.backend.demo.domain.AuthenticationResponse;
import com.backend.demo.domain.Services.DemoUserDetailService;
import com.backend.demo.web.security.JWTUtil;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DemoUserDetailService demoUserDetails;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/autentificacion")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(),request.getClave()));
            UserDetails userDetails= demoUserDetails.loadUserByUsername(request.getUsuario());
            System.out.println(userDetails.getUsername());
            String jwt=jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt,""));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
