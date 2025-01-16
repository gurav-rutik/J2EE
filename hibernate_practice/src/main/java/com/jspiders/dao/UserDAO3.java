package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.dto.UserDTO;

public class UserDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		
		UserDTO userDTO = entityManager.find(UserDTO.class, 2);
		if(userDTO != null) {
			userDTO.setMobile(9607194594l);
			userDTO.setEmail("pratik@gmail.com");
			userDTO.setPassword("Pratik@567");
			
			entityTransaction.begin();
			entityManager.persist(userDTO);
			entityTransaction.commit();
		}else {
			System.out.println("User not found!");
		}
		
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demo");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
