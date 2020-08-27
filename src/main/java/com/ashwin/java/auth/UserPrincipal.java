package com.ashwin.java.auth;

import java.security.Principal;
import java.util.Set;

public class UserPrincipal implements Principal {
    private final String name;

    private final Set<String> roles;

    public UserPrincipal() {
        this.name = null;
        this.roles = null;
    }

    public UserPrincipal(String name) {
        this.name = name;
        this.roles = null;
    }

    public UserPrincipal(String name, Set<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return (int) (Math.random() * 100);
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserPrincipal{" +
                "name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
