package com.jspiders.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {
	public static void main(String[] args) {
		
		File file = new File("D:\\File\\pratik.txt");
		
		if(!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(65);
			
			System.out.println("Data is successfully written to a file.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong..");
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
