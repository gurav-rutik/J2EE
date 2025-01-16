package com.jspiders.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterStreamReadScanner {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("D:\\File\\pratik.txt");
		
		if(file.exists()) {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			
			scanner.close();
		}
	}
}
