package com.amudhan.springcore.transaction;

public interface StudentService {
	Student getStudent(Long id);
	void insertStudent(String name, int age);
	void updateStudent(int id, String name, int age);
	void deleteStudent(int id);
}
