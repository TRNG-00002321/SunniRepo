package com.revature.daodemo;

import com.revature.daodemo.dao.UserDAO;
import com.revature.daodemo.dao.UserJDBCImpl;
import com.revature.daodemo.model.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserJDBCImpl();
        User user = userDAO.getUser(0);
        System.out.println(user);
    }
}
