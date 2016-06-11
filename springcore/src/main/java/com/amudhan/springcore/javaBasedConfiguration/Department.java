package com.amudhan.springcore.javaBasedConfiguration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Department {
	private String name;
	private Teacher teacher;
	
	public Department(){
		
	}
	public Department(Teacher teacher){
		this.teacher=teacher;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", teacher=" + teacher + "]";
	}
	
}
