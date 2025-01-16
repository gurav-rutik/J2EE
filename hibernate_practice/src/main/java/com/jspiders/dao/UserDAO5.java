package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.dto.UserDTO;

public class UserDAO5 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static Query query;
	
	public static void main(String[] args) {
		openConnection();
		
		query = entityManager.createQuery("SELECT user FROM UserDTO user WHERE id=?1");
		query.setParameter(1, 1);
		
		try {
			UserDTO userDTO = (UserDTO) query.getSingleResult();
			System.out.println(userDTO);
		} catch (NoResultException e) {
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
