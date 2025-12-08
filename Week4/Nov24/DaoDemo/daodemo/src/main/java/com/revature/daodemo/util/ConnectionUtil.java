package com.revature.daodemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Connection connection = null;

    public static Connection dbConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "password");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
