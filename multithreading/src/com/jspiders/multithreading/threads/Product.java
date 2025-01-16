package com.jspiders.multithreading.threads;

public class Product {
	private boolean available;
	
	synchronized public void order() throws InterruptedException {
		if(this.available) {
			System.out.println("product is currently available.");
			System.out.println("Order is placed.");
		}else {
			System.out.println("product is currently not available.");
			
			wait();
			
			if(this.available) {
				System.out.println("product is currently available.");
				System.out.println("Order is placed.");
			}
		}
	}
	
	synchronized public void manufacture() {
		this.available = true;
		notifyAll();
	}
}
