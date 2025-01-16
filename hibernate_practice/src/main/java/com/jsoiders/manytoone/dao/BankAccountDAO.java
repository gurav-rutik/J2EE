package com.jsoiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.manytoone.dto.BankAccount;
import com.jsoiders.manytoone.dto.BankAccountHolder;

public class BankAccountDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		BankAccountHolder bankAccountHolder = new BankAccountHolder();
		bankAccountHolder.setHolderName("Vikas Yelgar");
		bankAccountHolder.setEmail("vikas@gmail.com");
		bankAccountHolder.setMobile(7391004594l);
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setBankName("SBI Bank");
		bankAccount1.setAccountNumber(475502010112233l);
		bankAccount1.setLocation("Pune");
		bankAccount1.setBankAccountHolder(bankAccountHolder);
		
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setBankName("Canara Bank");
		bankAccount2.setAccountNumber(475502010989898l);
		bankAccount2.setLocation("Mumbai");
		bankAccount2.setBankAccountHolder(bankAccountHolder);
		
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(bankAccountHolder);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(bankAccount1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(bankAccount2);
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
