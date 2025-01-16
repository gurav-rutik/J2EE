package com.jspiders.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamRead {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\File\\pratik.txt");
		String data = "";
		
		if(file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			int ascii = -1;
			
			while((ascii = fileInputStream.read()) != -1) {
				data += (char) ascii;
			}
			System.out.println(data);
			
			fileInputStream.close();
		}else {
			System.out.println("File does not exixts.");
		}
	}
}
