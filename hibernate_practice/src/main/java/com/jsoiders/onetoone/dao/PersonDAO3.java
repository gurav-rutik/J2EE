package com.jsoiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.onetoone.dto.AadharCard;
import com.jsoiders.onetoone.dto.Person;

public class PersonDAO3 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		
		openConnection();
		
		Person person = entityManager.find(Person.class, 4);
		if(person != null) {
			person.setName("Ram Gurav");
			person.setMobile(1234567890l);
			
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			
			AadharCard aadharCard = person.getAadharCard();
			aadharCard.setAadharNumber(122412241224l);
			aadharCard.setAddress("Satara");
			
			entityTransaction.begin();
			entityManager.persist(aadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("Person not found!");
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
