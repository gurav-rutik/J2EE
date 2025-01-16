package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.DatabaseConn;

public class DatabaseConnDriver {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.springcore.bean");
		DatabaseConn bean = applicationContext.getBean(DatabaseConn.class);
		System.out.println(bean);
		
		((AnnotationConfigApplicationContext)applicationContext).close();
	}
}
