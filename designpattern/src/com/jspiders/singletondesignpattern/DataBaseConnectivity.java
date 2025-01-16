package com.jspiders.singletondesignpattern;

import java.sql.Connection;

public class DataBaseConnectivity {
	
	//Lazy instantiation
	private static DataBaseConnectivity connection;

	private DataBaseConnectivity() {
		super();
	}
	
	public static DataBaseConnectivity getConnection() {
		if(connection == null) {
			connection = new DataBaseConnectivity();
		}
		
		return connection;
	}
}
