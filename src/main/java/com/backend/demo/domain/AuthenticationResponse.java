package com.backend.demo.domain;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private String msj;

    public AuthenticationResponse(String jwt, String msj) {
        this.jwt = jwt;
        this.msj=msj;
    }
}
