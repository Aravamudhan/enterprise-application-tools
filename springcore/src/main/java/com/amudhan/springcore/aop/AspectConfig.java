package com.amudhan.springcore.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.amudhan.springcore.javaBasedConfiguration.Department;
import com.amudhan.springcore.javaBasedConfiguration.Student;
import com.amudhan.springcore.validation.Contact;

@Configuration
@ComponentScan(basePackages="com.amudhan.springcore.aop")
@ComponentScan(basePackages="com.amudhan.springcore.autowiring")
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public Contact contact(){
		Contact contact = new Contact();
		return contact;
	}
	
	@Bean
	public Student student() {
		return new Student();
	}
	
	@Bean
	public Department department() {
		return new Department();
	}
	
	@Bean
	public Account account() {
		return new Account("Personal");
	}

}
