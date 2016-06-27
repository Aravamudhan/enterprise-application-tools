package com.amudhan.springcore.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amudhan.springcore.autowiring.Movie;
import com.amudhan.springcore.javaBasedConfiguration.Department;
import com.amudhan.springcore.javaBasedConfiguration.Student;
import com.amudhan.springcore.validation.Contact;

public class SimpleAspectTestApp {

	private static final Logger logger = LoggerFactory.getLogger(SimpleAspectTestApp.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AspectConfig.class);
		Contact contact = (Contact) context.getBean("contact");
		contact.setMailId("testmail@mail.com");
		contact.getMailId();

		Movie movie = (Movie) context.getBean("movie");
		movie.setName("Godfather");
		movie.getName();

		Student student = (Student) context.getBean("student");
		Department department = (Department) context.getBean("department");
		department.setName("Computer Science");
		student.setName("Amudhan");
		student.setDepartment(department);
		logger.info("Student name "+student.getName());

		Account account = (Account) context.getBean("account");
		account.getAccountName();
	}
}
