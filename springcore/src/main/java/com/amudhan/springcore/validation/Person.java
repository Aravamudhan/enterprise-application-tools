package com.amudhan.springcore.validation;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private int age;
	private String name;
	@Autowired
	private Contact contact;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", contact=" + contact
				+ "]";
	}
}
