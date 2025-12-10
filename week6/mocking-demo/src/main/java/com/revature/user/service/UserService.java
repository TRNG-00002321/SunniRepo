package com.revature.user.service;

import com.revature.user.dao.UserRepository;
import com.revature.user.model.User;

public class UserService {
    UserRepository repo;
    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public User getUserById(Long id){
        return repo.findById(id);
    }
    public boolean register(User user){
        if(repo.findByEmail(user.getEmail()) != null)
            return false;
        repo.save(user);
        return true;
    }
}
