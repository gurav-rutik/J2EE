package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.dto.UserDTO;

public class UserDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		openConnection();
		
		UserDTO userDTO = entityManager.find(UserDTO.class, 2);
		if(userDTO != null) {
			System.out.println(userDTO);
		}else {
			System.out.println("User not found!");
		}
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demo");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
	}
}
