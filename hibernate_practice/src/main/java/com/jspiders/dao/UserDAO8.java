package com.jspiders.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.dto.UserDTO;

public class UserDAO8 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	public static void main(String[] args) {
		openConnection();
		
		UserDTO userDTO = entityManager.find(UserDTO.class, 6);
		
		if(userDTO != null) {
			query = entityManager.createQuery("UPDATE UserDTO user SET mobile=?1, email=?2, password=?3 WHERE id=?4");
			query.setParameter(1, 1122334455l);
			query.setParameter(2, "Vikas12@gmail.com");
			query.setParameter(3, "Vikas@890");
			query.setParameter(4, 6);
			
			entityTransaction.begin();
			query.executeUpdate();
			entityTransaction.commit();
			
		}else {
			System.out.println("User is not found!");
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
