package com.backend.demo.domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.demo.domain.UsuarioEntidad;
import com.backend.demo.domain.Repository.UserRepositoryI;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepositoryI userRepositoryI;

    public UsuarioEntidad save(UsuarioEntidad user){
        return userRepositoryI.saveUser(user);
    }
    
}
