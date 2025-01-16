package com.jspiders.multithreading;

import com.jspiders.multithreading.threads.ProductService;
import com.jspiders.multithreading.threads.ProductServiceConsumer;

public class ProductServiceMain {
	public static void main(String[] args) {
		
		ProductService productService = new ProductService();
		
		new ProductServiceConsumer(productService).start();
		new ProductServiceConsumer(productService).start();
		new ProductServiceConsumer(productService).start();
		new ProductServiceConsumer(productService).start();
		new ProductServiceConsumer(productService).start();
		new ProductServiceConsumer(productService).start();
		
//		new ProductServiceproducer(productService).start();

	}
}
