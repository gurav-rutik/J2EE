package com.jspiders.multithreading;

import com.jspiders.multithreading.threads.MyThread1;
import com.jspiders.multithreading.threads.MyThread2;

public class App1 {
	public static void main(String[] args) {
		
//		MyThread1 myThread1 = new MyThread1();
//		Thread thread = new Thread(myThread1);
//		
//		MyThread2 myThread2 = new MyThread2();
//		Thread thread2 = new Thread(myThread2);
		
//		thread.start();
//		thread2.start();
		
		new Thread(new MyThread1()).start();
		new Thread(new MyThread2()).start();
	}
}
