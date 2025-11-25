package com.revature.daodemo.dao;

import java.util.List;

import com.revature.daodemo.model.User;

public interface UserDAO {
    public default List<User> getAllUsers() {
        return null;
    }

    public default User getUser(int id) {
        return null;
    }

    public default void save(User user) {
    }

    public default User update(int id) {
        return null;
    }

    public default void delete(int id) {
    }
}
