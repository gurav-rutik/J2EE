package com.jspiders.serializationdeserialization.main;

import java.io.IOException;

import com.jspiders.serializationdeserialization.Messanger;

public class MessangerMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Messanger messanger = new Messanger();
		messanger.send("Hello Rutik!!");
		
		System.out.println(messanger.receive());
	}
}
