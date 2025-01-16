package com.jsoiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsoiders.onetomany.dto.Company;
import com.jsoiders.onetomany.dto.Employee;


public class CompanyDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		openConnection();
		
		Company company = entityManager.find(Company.class, 2);
		
		if(company != null) {
			System.out.println(company);
			
			List<Employee> employees = company.getEmployee();
			for(Employee employee:employees) {
				System.out.println(employee);
			}
		}else {
			System.out.println("Company is not found!");
		}
		
		closeConenction();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("demo");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	private static void closeConenction() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
	}
}
