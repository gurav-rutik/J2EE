package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUpdate {
	private static Driver driver; //iterface
	private static Connection connection; //iterface
	private static Statement statement; //iterface
	private static String query;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement(); //initialize the statements
			query = "update users set password = 'rutik@12345' where id=1";
			statement.execute(query);
			System.out.println("Record is updated");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
//			System.out.println("चुकलास भावा!!");
		}finally {
			try {
				closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
//		forName is static method of class Class
		Class.forName("com.mysql.cj.jdbc.Driver"); //passed fullyqualifiedname of class--> explicitly we load driver
		driver = new com.mysql.cj.jdbc.Driver();  // passed fullyqualifiedname of class to differentiate two classes --> inititalize driver
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");  //--> inititalize connection
		//DriverManager has getconnection() is factory method because it returns the Connection object
	}
	
	private static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		if(driver !=null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}
