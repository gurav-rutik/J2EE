package com.jsoiders.manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsoiders.manytomany.dto.Student;
import com.jsoiders.manytomany.dto.Subject;

public class StudentDAO3 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		
		Student student = entityManager.find(Student.class, 2);
		if(student != null) {
			student.setEmail("pratik24@gmail.com");
			student.setMobile(9607194594l);
			
			List<Subject> subjects = student.getSubjects();
			for(Subject subject:subjects) {
				if(subject != null && !subjects.isEmpty()) {
					if(subject.getId()==1) {
						subject.setName("SQL");
					}
					if(subject.getId()==2) {
						subject.setFees(15500);
					}
				}
			}
			
			student.setSubjects(subjects);
			
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}else {
			System.out.println("Student not found!");
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
