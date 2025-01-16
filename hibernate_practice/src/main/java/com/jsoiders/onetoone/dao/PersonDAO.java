package com.jsoiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.onetoone.dto.AadharCard;
import com.jsoiders.onetoone.dto.Person;

public class PersonDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setAadharNumber(567881077244l);
		aadharCard.setAddress("Delhi");
		
		Person person = new Person();
		person.setName("Ram");
		person.setEmail("ram@gmail.com");
		person.setMobile(9765725602l);
		person.setAadharCard(aadharCard);
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
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
