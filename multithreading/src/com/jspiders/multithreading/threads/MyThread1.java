package com.jspiders.multithreading.threads;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		for(int i=1;i<=10;i++) {
			System.out.println(thread.getName()+" is running..");
		}
		
	}

}
