package com.jspiders.multithreading.threads;

public class MyThread3 extends Thread{
	private Resource resource;

	public MyThread3(Resource resource) {
		super();
		this.resource = resource;
	}
	
	public void run() {
		for(int i=1;i<=1000;i++) {
			resource.increment();
		}
	}
}
