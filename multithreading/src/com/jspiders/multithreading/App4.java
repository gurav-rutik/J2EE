package com.jspiders.multithreading;

import com.jspiders.multithreading.threads.Consumer;
import com.jspiders.multithreading.threads.Producer;
import com.jspiders.multithreading.threads.Product;

public class App4 {
	public static void main(String[] args) {
		
		Product product = new Product();
		
		new Consumer(product).start();
		new Producer(product).start();
	}
}
