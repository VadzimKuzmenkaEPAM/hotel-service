package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    public UserDetails loadUserByLogin(String login);
}
