package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertDataBatch {

    private static Driver driver;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static String query;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            openConnection();
            
            // SQL query for inserting data into the 'users' table
            query = "INSERT INTO users (id, name, email, mobile) VALUES (?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(query);

            System.out.println("Enter number of records to be inserted: ");
            int records = scanner.nextInt();

            for (int i = 1; i <= records; i++) {
                System.out.println("Enter user id: ");
                int id = scanner.nextInt();
                
                System.out.println("Enter user name: ");
                String name = scanner.next();
                
                System.out.println("Enter user email: ");
                String email = scanner.next();
                
                System.out.println("Enter user mobile: ");
                long mobile = scanner.nextLong();

                // Set the values for the placeholders
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, email);
                preparedStatement.setLong(4, mobile);

                // Add the current insert statement to the batch
                preparedStatement.addBatch();
            }

            scanner.close();

            // Execute the batch of insert statements
            int[] res = preparedStatement.executeBatch();
            int rows = 0;

            // Count the number of successful inserts
            for (int i : res) {
                if (i != 0) {
                    rows += i;
                }
            }

            System.out.println("\n" + rows + " row(s) inserted successfully.");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        } finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openConnection() throws ClassNotFoundException, SQLException {
        // Load and register the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        driver = new com.mysql.cj.jdbc.Driver();
        
        // Establish the connection to the MySQL database
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rutik?user=root&password=root");
    }

    private static void closeConnection() throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (driver != null) {
            DriverManager.deregisterDriver(driver);
        }
    }
}
