package com.backend.demo.web.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

@Component
public class JWTUtil {   
    //crea una clave secreta por nosotros
    SecretKey key = Jwts.SIG.HS256.key().build();
    //guardamos la clave secreta
    public final  String secretString = Encoders.BASE64.encode(key.getEncoded());
   
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().subject(userDetails.getUsername()).issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+1000*60*60*10))
        .signWith(key).compact();
    }
    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUser(token)) && !isTokenExpired(token);
    }
    public String extractUser(String token){
        return getClaims(token).getSubject();
    }
    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
    private Claims getClaims(String token){
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }
}
