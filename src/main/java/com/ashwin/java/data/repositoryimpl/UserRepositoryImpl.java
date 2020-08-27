package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.local.LocalUsers;
import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private LocalUsers localUsers;

    @Inject
    public UserRepositoryImpl(LocalUsers localUsers) {
        this.localUsers = localUsers;
    }

    @Override
    public List<User> get() throws Exception {
        return this.localUsers.get();
    }

    @Override
    public User get(long id) throws Exception {
        return this.localUsers.get(id);
    }
}
