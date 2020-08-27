package com.ashwin.java;

import com.ashwin.java.auth.BasicAuthenticator;
import com.ashwin.java.auth.BasicAuthorizer;
import com.ashwin.java.auth.UserPrincipal;
import com.ashwin.java.di.BasicAuthModule;
import com.ashwin.java.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class BasicAuthApplication extends Application<BasicAuthConfiguration> {
    public static void main(String[] args) throws Exception {
        new BasicAuthApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-basic-auth";
    }

    @Override
    public void run(BasicAuthConfiguration config, Environment env) throws Exception {
        env.jersey().getResourceConfig().register(new BasicAuthModule());

        env.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<UserPrincipal>()
            .setAuthenticator(new BasicAuthenticator())
            .setAuthorizer(new BasicAuthorizer())
            .setRealm("BASIC-AUTH-REALM")
            .buildAuthFilter()
        ));
        env.jersey().register(RolesAllowedDynamicFeature.class);
        env.jersey().register(new AuthValueFactoryProvider.Binder<>(UserPrincipal.class));

        env.jersey().register(UserResource.class);
    }
}
