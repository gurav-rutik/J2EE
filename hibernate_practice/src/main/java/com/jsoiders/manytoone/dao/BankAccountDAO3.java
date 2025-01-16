package com.jsoiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.manytoone.dto.BankAccount;
import com.jsoiders.manytoone.dto.BankAccountHolder;

public class BankAccountDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		
		BankAccount bankAccount = entityManager.find(BankAccount.class, 3);
		if(bankAccount != null) {
			
			BankAccountHolder bankAccountHolder = bankAccount.getBankAccountHolder();
			if(bankAccountHolder != null) {
				if(bankAccountHolder.getId()==2) {
					bankAccountHolder.setMobile(9607194594l);
					bankAccountHolder.setEmail("vikas12@gmail.com");
				}else {
					System.out.println("Id not found!");
				}
			}else {
				System.out.println("Bank Account Holder not found!");
			}
			
			bankAccount.setBankAccountHolder(bankAccountHolder);
			
			entityTransaction.begin();
			entityManager.persist(bankAccount);
			entityTransaction.commit();
		
		}else {
			System.out.println("Bank Account is not found!");
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
