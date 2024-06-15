package com.backend.demo.domain.Services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class DemoUserDetailService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("emilio", "$2a$12$z2Y9GDYzuCyunXfkneoE5ediGmhRzu74wlTH4KfsDZMk3rWxCDXfq", new ArrayList<>());
    }
    
}
