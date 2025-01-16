package com.jspiders.filehandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D://File//pratik.txt");
		
		boolean isCreated = file.createNewFile();
		
		if(isCreated) {
			System.out.println("File is successfully created.");
		}else {
			System.out.println("File is already present.");
		}
	}
}
