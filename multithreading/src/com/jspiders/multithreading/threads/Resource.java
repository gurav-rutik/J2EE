package com.jspiders.multithreading.threads;

public class Resource {
	private static int count;
	
	synchronized public void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
}
