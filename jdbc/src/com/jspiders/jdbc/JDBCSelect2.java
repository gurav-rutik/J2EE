package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect2 {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
	
		
		try {
			openConnection();
//			static query--> executed during compilation time
//			query = "INSERT INTO users VALUES(3,'VIKAS','vikas@gmail.com',1234567891,'vikas@123')";
			
//			dynamic query --> query executed during compilation time but data inserted during run time
			query = "SELECT name, password FROM users WHERE id=?";
			preparedStatement = connection.prepareStatement(query); 
			
			preparedStatement.setInt(1, 1);
//			preparedStatement.setInt(1, 10);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("password"));
//				System.out.println(resultSet.getString("email"));
			}else {
				System.out.println("Invalid id");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
	}
	
	private static void closeConnection() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}
