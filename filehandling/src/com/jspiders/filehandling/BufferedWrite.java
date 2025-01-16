package com.jspiders.filehandling;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWrite {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\File\\demo.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("Hello Rutik!");
		bufferedWriter.newLine();
		bufferedWriter.write("Hello");
		bufferedWriter.close();
		fileWriter.close();
	}
}
