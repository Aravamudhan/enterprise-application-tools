package com.amudhan.springcore.transaction;

public interface StudentDao {
	Student getStudent(Long id);
	void insertStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int id);
}
