package com.jsoiders.manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsoiders.manytomany.dto.Student;
import com.jsoiders.manytomany.dto.Subject;
import com.jsoiders.onetomany.dto.Employee;

public class SubjectDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
	public static void main(String[] args) {
		
		openConnection();
		
		query = entityManager.createQuery("SELECT student FROM Student student");
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();
		
		for(Student student:students) {
			List<Subject> subjects = student.getSubjects();
			Subject subjectToBeDeleted = null;
			
			for(Subject subject:subjects) {
				if(subject.getId()==2) {
					subjectToBeDeleted = subject;
					break;
				}
			}
			if(subjectToBeDeleted != null) {
				subjects.remove(subjectToBeDeleted);
				student.setSubjects(subjects);
				
				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();
			}
		}
		Subject subject = entityManager.find(Subject.class, 2);
		entityTransaction.begin();
		entityManager.remove(subject);
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
