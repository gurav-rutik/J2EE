package com.jsoiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsoiders.manytoone.dto.BankAccount;
import com.jsoiders.manytoone.dto.BankAccountHolder;

public class BankAccountDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		openConnection();
		
		BankAccount bankAccount = entityManager.find(BankAccount.class, 4);
		if(bankAccount != null) {
			System.out.println(bankAccount);
			
			BankAccountHolder bankAccountHolder = bankAccount.getBankAccountHolder();
			System.out.println(bankAccountHolder);
		}else {
			System.out.println("Bank Account not found!");
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
