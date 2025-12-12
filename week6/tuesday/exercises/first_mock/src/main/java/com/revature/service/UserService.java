package com.revature.service;

import java.util.List;

import com.revature.UserRepository;
import com.revature.model.User;

public class UserService {

    UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser(Long id) {
        return repo.findById(id);
    }

    public boolean register(User user) {
        if (repo.findByEmail(user.getEmail()) != null) {
            return false;
        }
        repo.save(user);
        return true;
    }

    public List<User> getActiveUsers() {
        return repo.findAllActive();
    }
}
