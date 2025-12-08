package com.revature.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JdbcPSDemo {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public static void main(String[] args) {
        try {
            // STEP 1. LOAD THE DRIVER -- OPTIONAL
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2. CREATE THE CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "password");

            String insertQuery = "INSERT INTO users(id, name, email) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, "859");
            preparedStatement.setString(2, "Charlie");
            preparedStatement.setString(3, "charlie234@email");
            preparedStatement.execute();
            preparedStatement.close();

            String preparedString = "SELECT * FROM users WHERE name LIKE ?";
            preparedStatement = connection.prepareStatement(preparedString);
            preparedStatement.setString(1, "charlie");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getString(2).toUpperCase() + ", "
                        + resultSet.getString("email"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
