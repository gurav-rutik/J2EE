package com.jspiders.multithreading.threads;

public class ProductServiceConsumer extends Thread {
	private ProductService productService;

	public ProductServiceConsumer(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	public void run() {
		try {
			productService.order("Rutik");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
