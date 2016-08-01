package com.amudhan.springcore.transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Student getStudent(Long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public void insertStudent(Student student) {
		Student persistentStudent = new Student();
		persistentStudent.setAge(student.getAge());
		persistentStudent.setName(student.getName());
		entityManager.persist(persistentStudent);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
