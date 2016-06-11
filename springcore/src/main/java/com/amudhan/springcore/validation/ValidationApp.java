package com.amudhan.springcore.validation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValidationApp {
	
	private static ApplicationContext context;
	
	public static void main(String[] args){
		context=new AnnotationConfigApplicationContext(ValidationBeanConfig.class);
		Person person=(Person)context.getBean("person");
		person.setAge(110);
		person.setName("");
		System.out.println(person);
	}

}
