package com.example.springsecurity.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role
{
    USER(Set.of(Permission.DEVELOPERS_READ)),
    ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> PERMISSIONS;

    Role(Set<Permission> permissions)
    {
        PERMISSIONS = permissions;
    }

    public Set<Permission> getPERMISSIONS()
    {
        return PERMISSIONS;
    }

    public Set<SimpleGrantedAuthority> getAuthorities()
    {
        return getPERMISSIONS().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPERMISSION()))
                .collect(Collectors.toSet());
    }
}
