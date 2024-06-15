package com.backend.demo.persistence.mapper;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.backend.demo.domain.UsuarioEntidad;
import com.backend.demo.persistence.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    @Mappings({
        @Mapping(source="userId",target="usuarioId"),
        @Mapping(source="firstName",target="nombre"),
        @Mapping(source="lastName",target="apellido"),
        @Mapping(source="document",target="documento"),
        @Mapping(source="password",target="clave"),
    })
    UsuarioEntidad toUsuarioEntidad(UserEntity user);
    List<UsuarioEntidad> toUsuariosEntidades(List<UserEntity> users);
   
    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target="createDate",ignore =true),
        @Mapping(target="updateDate",ignore =true)
    })
    UserEntity toUserEntity(UsuarioEntidad usuario);
}
