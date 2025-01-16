package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.serializationdeserialization.User;

public class DeSerialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("D:\\File\\demo.txt");
		
		if(file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			User user = (User) objectInputStream.readObject();
			
			System.out.println(user);
			
			fileInputStream.close();
			objectInputStream.close();
		}else {
			System.out.println("File does not found!");
		}
	}
}
