package com.jsoiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.onetomany.dto.Company;
import com.jsoiders.onetomany.dto.Employee;


public class CompanyDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		Employee employee1 = new Employee();
		employee1.setName("Vikas Yelgar");
		employee1.setEmail("vikas@gmail.com");
		employee1.setMobile(9730323328l);
		employee1.setSalary(40000);
		
		Employee employee2 = new Employee();
		employee2.setName("Aakash");
		employee2.setEmail("aakash@gmail.com");
		employee2.setMobile(9168885958l);
		employee2.setSalary(41000);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		
		Company company = new Company();
		company.setName("Google");
		company.setLocation("Benglore");
		company.setEmployee(employees);
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(employee1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(employee2);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
		
		closeConenction();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demo");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConenction() {
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
