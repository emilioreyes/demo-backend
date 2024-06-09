package com.backend.demo.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.demo.domain.UsuarioEntidad;
import com.backend.demo.domain.Repository.UserRepositoryI;
import com.backend.demo.persistence.Crud.UserCrudRepository;
import com.backend.demo.persistence.entity.UserEntity;

@Repository
public class UserRepository implements UserRepositoryI {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Override
    public UsuarioEntidad saveUser(UsuarioEntidad usuario) {
        UserEntity entity=new UserEntity();
        entity.setFirstName(usuario.getNombre());
        entity.setLastName(usuario.getApellido());
        entity.setDocument(usuario.getDocumento());
       
       entity=userCrudRepository.save(entity);
       UsuarioEntidad usuarioDominio=new UsuarioEntidad();
       usuarioDominio.setUsuarioId(entity.getUserId());
       usuarioDominio.setNombre(entity.getFirstName());
       usuarioDominio.setApellido(entity.getLastName());
       usuarioDominio.setDocumento(entity.getDocument());
       return usuarioDominio;
    }

    @Override
    public UsuarioEntidad apdateUser(UsuarioEntidad usuario, Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apdateUser'");
    }

    @Override
    public List<UsuarioEntidad> getAllUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }
    
}
