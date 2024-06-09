package com.backend.demo.persistence.Crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.demo.persistence.entity.UserEntity;

public interface UserCrudRepository extends JpaRepository<UserEntity,Integer> {
    
}
