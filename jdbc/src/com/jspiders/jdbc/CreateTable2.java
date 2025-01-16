package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable2 {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			statement.execute("CREATE TABLE users(id int primary key, name varchar(20) not null, email varchar(20) not null unique, mobile bigint(10) not null unique, password varchar(20) not null unique)");
			
			System.out.println("Table is created");
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
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratik?user=root&password=root");
	}
	
	private static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}
