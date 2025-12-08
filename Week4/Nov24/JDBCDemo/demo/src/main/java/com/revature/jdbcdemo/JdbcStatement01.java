package com.revature.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatement01 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // STEP 1. LOAD THE DRIVER -- OPTIONAL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2. CREATE THE CONNECTION
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "password");

            // STEP 3. CREATE THE STATEMENT OBJECT
            statement = connection.createStatement();
            String selectQuery = "SELECT * FROM users;";

            // STEP 4. EXECUTE THE QUERY AND COLLECT THE RESULT IN RESULT SET
            resultSet = statement.executeQuery(selectQuery);

            // STEP 5. PROCESS THE RESULT SET
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getString(2).toUpperCase() + ", "
                        + resultSet.getString("email"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Database Connected...");

    }
}
