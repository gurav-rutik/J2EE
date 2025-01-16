package com.jspiders.serializationdeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Messanger {
	private static FileOutputStream fileOutputStream;
	private static ObjectOutputStream objectOutputStream;
	private static FileInputStream fileInputStream;
	private static ObjectInputStream objectInputStream;
	private static File file = new File("D:\\File\\demo.txt");
	
	public void send(String message) throws IOException {
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(message);
	}
	
	public String receive() throws IOException, ClassNotFoundException {
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		return (String)objectInputStream.readObject();
	}
	
}
