package com.jsoiders.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.onetomany.dto.Company;
import com.jsoiders.onetomany.dto.Employee;


public class CompanyDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		
		Company company = entityManager.find(Company.class, 1);
		if(company != null) {
			company.setName("Tech Mahindra");
			
			List<Employee> employees = company.getEmployee();
			for(Employee employee:employees) {
				if(employee != null && !employees.isEmpty()) {
					if(employee.getId()==1) {
						employee.setSalary(35000);
					}
					if(employee.getId()==2) {
						employee.setMobile(9607194594l);
					}
				}
			}
			company.setEmployee(employees);
			
			entityTransaction.begin();
			entityManager.persist(company);
			entityTransaction.commit();
		}else {
			System.out.println("Company not found!");
		}
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
