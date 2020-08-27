package com.ashwin.java.data.source.local;

import com.ashwin.java.domain.model.User;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocalUsers {
    private Map<Long, User> userMap;

    public LocalUsers() {
        userMap = ImmutableMap.of(
                1L, new User(1L, "alice", "Alice Ledger", "alice@gmail.com"),
                2L, new User(2L, "bob", "Bob Willis", "bob10@gmail.com"),
                3L, new User(3L, "clara", "Clara Steven", "clara@yahoo.com")
        );
    }

    public List<User> get() {
        return new ArrayList<User>(userMap.values());
    }

    public User get(long id) {
        return userMap.get(id);
    }
}
