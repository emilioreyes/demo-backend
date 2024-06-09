package com.backend.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class ServiceDemo {
    @RequestMapping("/saludar")
    public String Saludar(){
        return "hola desd spring";
    }
    
}
