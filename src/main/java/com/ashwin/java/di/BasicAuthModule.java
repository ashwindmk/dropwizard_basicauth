package com.ashwin.java.di;

import com.ashwin.java.data.repositoryimpl.UserRepositoryImpl;
import com.ashwin.java.data.source.local.LocalUsers;
import com.ashwin.java.domain.repository.UserRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class BasicAuthModule extends AbstractBinder {
    @Override
    protected void configure() {
        bind(LocalUsers.class).to(LocalUsers.class).in(Singleton.class);
        bind(UserRepositoryImpl.class).to(UserRepository.class).in(Singleton.class);
    }
}
