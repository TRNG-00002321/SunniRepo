package com.revature;

import java.util.List;

import com.revature.model.User;

// UserRepository.java - Interface to mock
public interface UserRepository {

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

    List<User> findAllActive();

    boolean existsByEmail(String email);

    User findByEmail(String email);

    long count();
}
