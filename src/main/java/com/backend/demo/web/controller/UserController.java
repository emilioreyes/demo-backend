package com.backend.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.domain.UsuarioEntidad;
import com.backend.demo.domain.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioEntidad> save(@RequestBody UsuarioEntidad user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntidad>> gatAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
}
