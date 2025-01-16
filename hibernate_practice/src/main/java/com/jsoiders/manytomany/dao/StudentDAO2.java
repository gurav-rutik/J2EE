package com.jsoiders.manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsoiders.manytomany.dto.Student;
import com.jsoiders.manytomany.dto.Subject;

public class StudentDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		openConnection();
		
		Student student = entityManager.find(Student.class, 2);
		if(student != null) {
			System.out.println(student);
			
			List<Subject> subjects = student.getSubjects();
			for(Subject subject:subjects) {
				System.out.println(subject);
			}
		}else {
			System.out.println("Student not found!");
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
