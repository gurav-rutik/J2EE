package com.jspiders.singletondesignpattern;


public class DataBase {

	public static void main(String[] args) {
		
		DataBaseConnectivity connection1 = DataBaseConnectivity.getConnection();
		DataBaseConnectivity connection2 = DataBaseConnectivity.getConnection();
		DataBaseConnectivity connection3 = DataBaseConnectivity.getConnection();
		DataBaseConnectivity connection4 = DataBaseConnectivity.getConnection();
		
		System.out.println(connection1);
		System.out.println(connection2);
		System.out.println(connection3);
		System.out.println(connection4);
	}
}
