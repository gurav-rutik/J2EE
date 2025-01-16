package com.jspiders.multithreading.threads;

public class Producer extends Thread {
	private Product product;

	public Producer(Product product) {
		super();
		this.product = product;
	}
	
	public void run() {
		product.manufacture();
	}
}
