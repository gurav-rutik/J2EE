package com.jspiders.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.dto.UserDTO;

public class UserDAO7 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static Query query;
	
	
	public static void main(String[] args) {
		openConnection();
		
		query = entityManager.createQuery("SELECT user FROM UserDTO user");
		
		@SuppressWarnings("unchecked")
		List<UserDTO> users = query.getResultList();
		
		if(users.size()>0) {
			for(UserDTO user:users) {
				System.out.println(user);
			}
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
