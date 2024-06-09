package com.backend.demo.domain;

import lombok.Data;

@Data
public class UsuarioEntidad {
    private Integer usuarioId;
    private String nombre;
    private String apellido;
    private String documento;
}
