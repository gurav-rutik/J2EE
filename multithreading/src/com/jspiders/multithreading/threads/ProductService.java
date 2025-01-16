package com.jspiders.multithreading.threads;

public class ProductService {
	private int stock=5;
	
	synchronized public void order(String userName) throws InterruptedException {
		System.out.println(userName+" trying to place order...");
		
		if(this.stock > 0) {
			System.out.println(userName+" successfully placed order.. Remaining stock : "+(--stock));
		}else {
			System.out.println("Out of the stock..");
			
			wait();
			
			if(this.stock > 0) {
				System.out.println(userName+" successfully placed order.. Remaining stock : "+(--stock));
			}
		}
	}
	
	synchronized public void manufacture() {
		this.stock++;
		notifyAll();
	}
	

}
