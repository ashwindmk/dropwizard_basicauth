package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.User;

import java.util.List;

public interface UserRepository {
    List<User> get() throws Exception;

    User get(long id) throws Exception;
}
