package com.jsoiders.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.onetomany.dto.Company;
import com.jsoiders.onetomany.dto.Employee;


public class EmployeeDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		
		Company company = entityManager.find(Company.class, 3);
		List<Employee> employees = company.getEmployee();
		Employee employeeToBeDeleted = null;
		
		for(Employee employee:employees) {
			if(employee.getId()==6) {
				employeeToBeDeleted = employee;
				break;
			}
		}
		if(employeeToBeDeleted != null) {
			employees.remove(employeeToBeDeleted);
			company.setEmployee(employees);
			
			entityTransaction.begin();
			entityManager.persist(company);
			entityTransaction.commit();
			
			entityTransaction.begin();
			entityManager.remove(employeeToBeDeleted);
			entityTransaction.commit();
		}else {
			System.out.println("Employee not found!");
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
