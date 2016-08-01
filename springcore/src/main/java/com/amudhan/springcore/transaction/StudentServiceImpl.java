package com.amudhan.springcore.transaction;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Inject
	private StudentDao studentDao;
	@Override
	public Student getStudent(Long id) {
		if(id==0)return null;
		return studentDao.getStudent(id);
	}

	@Override
	public void insertStudent(String name, int age) {
		Student persistentStudent = new Student();
		persistentStudent.setAge(age);
		persistentStudent.setName(name);
		studentDao.insertStudent(persistentStudent);
	}

	@Override
	public void updateStudent(int id, String name, int age) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStudent(int id) {
		throw new UnsupportedOperationException();
	}


}
