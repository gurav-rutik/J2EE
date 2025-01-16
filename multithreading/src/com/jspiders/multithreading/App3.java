package com.jspiders.multithreading;

import com.jspiders.multithreading.threads.MyThread3;
import com.jspiders.multithreading.threads.Resource;

public class App3 {
	public static void main(String[] args) throws InterruptedException {
		
		Resource resource = new Resource();
		
		MyThread3 thread1 = new MyThread3(resource);
		MyThread3 thread2 = new MyThread3(resource);
		
		thread1.start();
		thread2.start();
		
		Thread.sleep(3000);
		
		System.out.println(resource.getCount());
		
	}
}
