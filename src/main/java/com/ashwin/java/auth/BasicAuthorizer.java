package com.ashwin.java.auth;

import io.dropwizard.auth.Authorizer;

import javax.annotation.Nullable;
import javax.ws.rs.container.ContainerRequestContext;

public class BasicAuthorizer implements Authorizer<UserPrincipal> {
    @Override
    public boolean authorize(UserPrincipal principal, String role) {
        return principal.getRoles() != null && principal.getRoles().contains(role);
    }

    @Override
    public boolean authorize(UserPrincipal principal, String role, @Nullable ContainerRequestContext requestContext) {
        return authorize(principal, role);
    }
}
