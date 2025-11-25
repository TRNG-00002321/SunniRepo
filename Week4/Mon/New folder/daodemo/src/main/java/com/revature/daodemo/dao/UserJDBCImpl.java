package com.revature.daodemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.daodemo.model.User;
import com.revature.daodemo.util.ConnectionUtil;

public class UserJDBCImpl implements UserDAO {
    Connection connection = null;
    User user = null;

    public User getUser(int id) {
        connection = ConnectionUtil.dbConnection();
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user = new User(
                        Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getString("email"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }
}
