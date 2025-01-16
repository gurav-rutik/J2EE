package com.jspiders.demoapp.test;

public class DynamicArray {
	private int arr[] = new int[5];
	private int index = 0;
	
	private int capacity = arr.length;
	
	public void add(int num) {
		if(index == capacity) {
			int[] temp = new int[2*capacity];
			for(int i=0;i<index;i++) {
				temp[i] = arr[i];
			}
			arr=temp;
			capacity = arr.length;
		}
		arr[index] = num;
		index++;
	}
	
	public void print() {
		for(int i=0;i<index;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

