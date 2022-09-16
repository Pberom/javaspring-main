package com.example.javaspring.models;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    User,
    Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}


