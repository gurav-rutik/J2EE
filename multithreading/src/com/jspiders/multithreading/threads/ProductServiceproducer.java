package com.jspiders.multithreading.threads;

public class ProductServiceproducer extends Thread {

	private ProductService productService;

	public ProductServiceproducer(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	public void run() {
		productService.manufacture();
	}
}
