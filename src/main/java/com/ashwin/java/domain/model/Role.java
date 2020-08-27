package com.ashwin.java.domain.model;

import com.google.common.collect.ImmutableSet;

public enum Role {
    GUEST("guest", "pass123", ImmutableSet.of()),
    USER("user", "pass1234", ImmutableSet.of("user")),
    ADMIN("admin", "pass12345", ImmutableSet.of("admin", "user")),
    ROOT("root", "pass123456", ImmutableSet.of("root", "admin", "user"));

    private final String user;
    private final String password;
    private final ImmutableSet<String> roles;

    Role(String user, String password, ImmutableSet<String> roles) {
        this.user = user;
        this.password = password;
        this.roles = roles;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public ImmutableSet<String> getRoles() {
        return this.roles;
    }
}
