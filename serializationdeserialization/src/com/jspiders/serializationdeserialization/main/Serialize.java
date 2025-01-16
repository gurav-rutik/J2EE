package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.User;

public class Serialize {

	public static void main(String[] args) {
		
		File file = new File("D:\\File\\demo.txt");
		User user = new User("Rutik", "rutikgurav15@gmail.com", 9011715158l, "Rutik@123");
		
		if(!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(user);
	
			System.out.println("Data is successfully serialized to a file.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
