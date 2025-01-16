package com.jspiders.singletondesignpattern;

import java.sql.Connection;

public class DataBaseConnectivity2 {
	
	//Eager instantiation
	private static DataBaseConnectivity2 connection = new DataBaseConnectivity2();

	private DataBaseConnectivity2() {
		super();
	}
	
	public static DataBaseConnectivity2 getConnection() {
		return connection;
	}
}
