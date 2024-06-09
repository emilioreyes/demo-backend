package com.backend.demo.domain.Repository;

import java.util.List;

import com.backend.demo.domain.UsuarioEntidad;

public interface UserRepositoryI {
    UsuarioEntidad saveUser(UsuarioEntidad usuario);
    UsuarioEntidad apdateUser(UsuarioEntidad usuario,Integer userId);
    List<UsuarioEntidad> getAllUser();
}
