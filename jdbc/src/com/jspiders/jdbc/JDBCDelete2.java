package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDelete2 {
	
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id :");
		int id = scanner.nextInt();
		System.out.println("Enter user name :");
		String name = scanner.next();
		System.out.println("Enter user email :");
		String email = scanner.next();
		System.out.println("Enter user contact :");
		long contact = scanner.nextLong();
		System.out.println("Enter user password :");
		String password = scanner.next();
		
		try {
			openConnection();
//			static query--> executed during compilation time
//			query = "INSERT INTO users VALUES(3,'VIKAS','vikas@gmail.com',1234567891,'vikas@123')";
			
//			dynamic query --> query executed during compilation time but data inserted during run time
			query = "DELETE FROM users WHERE id=?";
			preparedStatement = connection.prepareStatement(query); // preparedStatement is faster because it insert the data of already compiled table (created table)
//			preparedStatement.setInt(1, 4);
//			preparedStatement.setString(2, "ROHAN");
//			preparedStatement.setString(3, "rohan@gmail.com");
//			preparedStatement.setLong(4, 9829824218l);
//			preparedStatement.setString(5, "rohan@123");
			
			preparedStatement.setInt(1, id);
			
			
			int rows = preparedStatement.executeUpdate();
			System.out.println("\n"+rows+" row(s) affected");
			
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
