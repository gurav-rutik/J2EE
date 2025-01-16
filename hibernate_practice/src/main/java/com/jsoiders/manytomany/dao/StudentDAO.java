package com.jsoiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.manytomany.dto.Student;
import com.jsoiders.manytomany.dto.Subject;

public class StudentDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		Subject subject1 = new Subject();
		subject1.setName("Core Java");
		subject1.setFees(10000);
		
		Subject subject2 = new Subject();
		subject2.setName("J2EE");
		subject2.setFees(15000);
		
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(subject1);
		subjects.add(subject2);
		
		Student student1 = new Student();
		student1.setName("Rutik Gurav");
		student1.setEmail("rutik@gmail.com");
		student1.setMobile(9011715158l);
		student1.setSubjects(subjects);
		
		Student student2 = new Student();
		student2.setName("Pratik Gurav");
		student2.setEmail("pratik@gmail.com");
		student2.setMobile(7391004594l);
		student2.setSubjects(subjects);
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(subject1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(subject1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(subject2);
		entityTransaction.commit();
		
		entityTransaction.begin();	
		entityManager.persist(student1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(student2);
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
