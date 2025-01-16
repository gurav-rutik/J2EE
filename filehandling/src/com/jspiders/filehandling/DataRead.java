package com.jspiders.filehandling;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataRead {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\File\\pratik.txt");
		
		if(file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			
			@SuppressWarnings("deprecation")
			String data = dataInputStream.readLine();
			System.out.println(data);
			
			fileInputStream.close();
			dataInputStream.close();
		}else {
			System.out.println("File does not exixst.");
		}
	}
}
