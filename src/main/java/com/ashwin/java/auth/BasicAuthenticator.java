package com.ashwin.java.auth;

import com.ashwin.java.domain.model.Role;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class BasicAuthenticator implements Authenticator<BasicCredentials, UserPrincipal> {
    @Override
    public Optional<UserPrincipal> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        try {
            Role role = Role.valueOf(basicCredentials.getUsername().toUpperCase());
            if (role.getPassword().equals(basicCredentials.getPassword())) {
                return Optional.of(new UserPrincipal(basicCredentials.getUsername(), role.getRoles()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
