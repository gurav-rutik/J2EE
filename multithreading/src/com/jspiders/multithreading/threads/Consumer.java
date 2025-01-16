package com.jspiders.multithreading.threads;

public class Consumer extends Thread {
	private Product product;

	public Consumer(Product product) {
		super();
		this.product = product;
	}
	
	public void run() {
		try {
			product.order();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
