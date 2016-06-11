package com.amudhan.springcore.javaBasedConfiguration;

import javax.annotation.Resource;

public class Student {
	private String name;
	@Resource
	private Department department;
	
	public Student(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + "]";
	}
}
