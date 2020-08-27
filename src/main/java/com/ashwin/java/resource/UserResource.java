package com.ashwin.java.resource;

import com.ashwin.java.auth.UserPrincipal;
import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;
import io.dropwizard.auth.Auth;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserResource {
    private UserRepository userRepository;

    @Inject
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PermitAll
    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNames(@Auth UserPrincipal principal) {
        List<String> names = new ArrayList<>();
        try {
            List<User> users = this.userRepository.get();
            for (User user : users) {
                names.add(user.getName());
            }
            return Response.ok(names).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @RolesAllowed({ "user" })
    @GET
    @Path("/usernames")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsernames(@Auth UserPrincipal principal) {
        List<String> usernames = new ArrayList<>();
        try {
            List<User> users = this.userRepository.get();
            for (User user : users) {
                usernames.add(user.getUsername());
            }
            return Response.ok(usernames).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @RolesAllowed({ "admin" })
    @GET
    @Path("/emails")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmails(@Auth UserPrincipal principal) {
        List<String> emails = new ArrayList<>();
        try {
            List<User> users = this.userRepository.get();
            for (User user : users) {
                emails.add(user.getEmail());
            }
            return Response.ok(emails).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @RolesAllowed({ "root" })
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@Auth UserPrincipal principal) {
        try {
            List<User> users = this.userRepository.get();
            return Response.ok(users).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
