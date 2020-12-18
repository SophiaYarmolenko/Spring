package com.example.springsecurity.model;

public enum Permission
{
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");
    private final String PERMISSION;

    Permission(String permission) {
        PERMISSION = permission;
    }

    public String getPERMISSION()
    {
        return PERMISSION;
    }
}
