package com.backend.demo.domain;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String usuario;
    private String clave;
}
