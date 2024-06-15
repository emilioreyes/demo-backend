package com.backend.demo.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.backend.demo.domain.UsuarioEntidad;
import com.backend.demo.domain.Repository.UserRepositoryI;
import com.backend.demo.persistence.Crud.UserCrudRepository;
import com.backend.demo.persistence.entity.UserEntity;
import com.backend.demo.persistence.mapper.UserEntityMapper;

@Repository
public class UserRepository implements UserRepositoryI {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public UsuarioEntidad saveUser(UsuarioEntidad usuario) {
        System.out.println(usuario.toString());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usuario.setClave(bCryptPasswordEncoder.encode(usuario.getClave()));
        UserEntity entity=userEntityMapper.toUserEntity(usuario); 
        return userEntityMapper.toUsuarioEntidad(userCrudRepository.save(entity));
    }

    @Override
    public UsuarioEntidad apdateUser(UsuarioEntidad usuario, Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apdateUser'");
    }

    @Override
    public List<UsuarioEntidad> getAllUser() {
        List<UserEntity> users=userCrudRepository.findAll(); 
        return userEntityMapper.toUsuariosEntidades(users);
    }
    
}
