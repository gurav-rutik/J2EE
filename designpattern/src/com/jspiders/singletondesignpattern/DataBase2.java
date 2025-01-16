package com.jspiders.singletondesignpattern;


public class DataBase2 {

	public static void main(String[] args) {
		
		DataBaseConnectivity2 connection1 = DataBaseConnectivity2.getConnection();
		DataBaseConnectivity2 connection2 = DataBaseConnectivity2.getConnection();
		DataBaseConnectivity2 connection3 = DataBaseConnectivity2.getConnection();
		DataBaseConnectivity2 connection4 = DataBaseConnectivity2.getConnection();
		
		System.out.println(connection1);
		System.out.println(connection2);
		System.out.println(connection3);
		System.out.println(connection4);
	}
}
