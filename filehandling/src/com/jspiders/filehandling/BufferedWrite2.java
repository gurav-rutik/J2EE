package com.jspiders.filehandling;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWrite2 {
	
	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;
	
	public static void main(String[] args) throws IOException {
		
		file = new File("D:\\File\\demo.txt");
		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);
		
		print("Hello Rutik!");
		print("Hii!");
		print("How are you?");
		
		bufferedWriter.close();
		fileWriter.close();
	}
	
	private static void print(String message) throws IOException {
		bufferedWriter.write(message);
		bufferedWriter.newLine();
	}
}
