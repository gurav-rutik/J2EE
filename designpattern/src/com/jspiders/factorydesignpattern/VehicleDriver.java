package com.jspiders.factorydesignpattern;

import java.util.Scanner;

public class VehicleDriver {
	public static void main(String[] args) {
		System.out.println("Enter 1 to book Mini");
		System.out.println("Enter 2 to book Sedan");
		System.out.println("Enter 3 to book SUV");
		System.out.println("Enter 4 to book Luxury");
		System.out.println("Enetr your choice");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		try {
			factory(choice).book();
		} catch (NullPointerException e) {
			System.out.println("Something wnt wrong!!");
		}
	}
	
	private static Vehicle factory(int choice) {
		
		Vehicle vehicle = null;
		
			
			switch (choice) {
			
			case 1: {
				vehicle = new Mini();
				
			}break;
			
			case 2: {
				vehicle = new Sedan();
				
			}break;
			
			case 3: {
				vehicle = new SUV();
				
			}break;
			
			case 4: {
				vehicle = new Luxury();
				
			}break;
			default:{
				
				System.out.println("Invalid choice!!");
			}
			}
			return vehicle;
	}
}
		
	

