package com.jspiders.demoapp.test1;

public class Main {

	public static void main(String[] args) {
		
		DynamicArray dynamicArray = new DynamicArray();
		
		dynamicArray.add(1);
		dynamicArray.add(2);
		dynamicArray.add(3);
		dynamicArray.add(4);
		dynamicArray.add(5);
		dynamicArray.add(6);
		dynamicArray.add(7);
		dynamicArray.add(8);
		dynamicArray.add(9);
		dynamicArray.add(10);

		
		dynamicArray.print();
		
		System.out.println("Deleting the datas at last index...");
		
		dynamicArray.delete();
		dynamicArray.print();
		
		dynamicArray.delete();
		dynamicArray.print();
		
		System.out.println("Deleting the datas at specified index...");
		
		dynamicArray.delete(2);
		dynamicArray.print();
		
		dynamicArray.delete(4);
		dynamicArray.print();
		
		dynamicArray.delete(10);
		dynamicArray.print();
		
		System.out.println("Setting the datas at particular index...");
		dynamicArray.set(2, 50);
		dynamicArray.set(10, 60);
		dynamicArray.print();
		
		System.out.println("Putting the datas at particular index...");
		dynamicArray.put(3, 20);
		dynamicArray.put(10,10);
		dynamicArray.print();
		

	}

}



