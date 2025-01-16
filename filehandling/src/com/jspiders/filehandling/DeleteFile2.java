package com.jspiders.filehandling;

import java.io.File;

public class DeleteFile2 {
	public static void main(String[] args) {
		
		File file = new File("pratik.txt");
		
		if(file.exists()) {
			boolean isDeleted = file.delete();
			
			if(isDeleted) {
				System.out.println("File is successfully deleted.");
			}else {
				System.out.println("Something went wrong.");
			}
		}else {
			System.out.println("File does not exists.");
		}
	}
}
