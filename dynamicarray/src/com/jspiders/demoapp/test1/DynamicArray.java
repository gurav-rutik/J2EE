package com.jspiders.demoapp.test1;

public class DynamicArray {
	private int arr[] = new int[5];
	private int index = 0;
	
	private int capacity = arr.length;
	
	
	public void add(int num) {
		if(index == (capacity-1)) {
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
	
	
	
	public void delete() {
		arr[index-1] = 0;
		index--;
	}
	
	public void delete(int i) {
		
		if(i>=0 && i<index) {
			for(int j=i;j<index-1;j++) {
				arr[j] = arr[j+1];
			}
			index--;
		}else {
			System.out.println("Invalid Index");
		}
	}
	
	public int get(int i) {
		int value=0;
		if(i>=0 && i<index) {
			value = arr[i];
		}else {
			System.out.println("Invalid Index");
		}
		return value;
	}
	
	public void set(int i, int value) {
		
		if(i>=0 && i<index) {
			arr[i] = value;
		}else {
			System.out.println("Invalid Index");
		}
	}
	
	public void put(int i, int value) {
		if(i>=0 && i<index) {
			for(int j=index-1;j>=i;j--) {
				arr[j+1] = arr[j];
			}
			arr[i] = value;
			index++;
		}else {
			System.out.println("Invalid Index");
		}
	}
	
	public void print() {
		for(int i=0;i<index;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

