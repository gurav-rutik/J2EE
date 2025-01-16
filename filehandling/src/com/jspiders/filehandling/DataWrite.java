package com.jspiders.filehandling;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataWrite {
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
		DataOutputStream dataOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			dataOutputStream = new DataOutputStream(fileOutputStream);
			dataOutputStream.writeBytes("Hello");
			
			System.out.println("Data is successfully written to a file.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong.");
		}finally {
			
			try {
				fileOutputStream.close();
				dataOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
