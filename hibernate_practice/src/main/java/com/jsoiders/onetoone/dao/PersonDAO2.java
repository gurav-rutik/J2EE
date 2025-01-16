package com.jsoiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsoiders.onetoone.dto.AadharCard;
import com.jsoiders.onetoone.dto.Person;

public class PersonDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		openConnection();
		
		Person person = entityManager.find(Person.class, 1);
		if(person != null) {
			System.out.println(person);
			
			AadharCard aadharCard = person.getAadharCard();
			System.out.println(aadharCard);
		}else {
			System.out.println("Person not found!");
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
