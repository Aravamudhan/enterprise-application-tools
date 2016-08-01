package com.amudhan.springcore.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amudhan.springcore.utils.RandomAlphaGenerator;
/*
 * This app is a demo for using transaction management in Spring.
 * A random string is created and inserted into the table.
 * Then update is made, which throws exception as expected.
 * Datasource configurations are in the transaction_dev.properties
 * */
public class StudentApp {
	
	private static ApplicationContext context;
	private static RandomAlphaGenerator randomAlpha = new RandomAlphaGenerator();
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StudentApp.class);
	 
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("transactionconfig.xml");
		StudentService studentService = (StudentService)context.getBean("studentServiceImpl");
		studentService.insertStudent(randomAlpha.randomString(), randomAlpha.randomInt(20, 50));
		studentService.updateStudent(100, "TestName", 30);
		studentService.insertStudent(randomAlpha.randomString(), randomAlpha.randomInt(20, 50));
	}

}
