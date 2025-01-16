package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class DeleteDataBatch {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		

		try {
			openConnection();
			
			query = "DELETE FROM users where id=?";
			
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the number of records to be deleted : ");
			int records = scanner.nextInt();
			
			for(int i=1;i<=records;i++) {
				System.out.println("Enter id to be deleted : ");
				int id = scanner.nextInt();
				
				preparedStatement.setInt(1, id);
				preparedStatement.addBatch();
			}
			
			
			int[] res = preparedStatement.executeBatch();
			int rows = 0;
			
			for(int i:res) {
				if(i!=0) {
					rows+=i;
				}
			}
			
			System.out.println("\n"+rows+" row(s) affected");
			
			scanner.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("SOmething went wrong");
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
		connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/rutik?user=root&password=root");
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
