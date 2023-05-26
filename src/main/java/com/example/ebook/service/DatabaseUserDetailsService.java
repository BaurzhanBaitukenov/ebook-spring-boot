package com.example.ebook.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DatabaseUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User("Admin", "$2a$10$fLVxFmvh5tUjyrAExUdxu.SOSMisAvWCOFZTMJDHW0TQREz2HiC/.", Collections.emptyList());
    }
}