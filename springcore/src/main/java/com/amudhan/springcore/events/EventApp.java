package com.amudhan.springcore.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventApp {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("eventconfig.xml");
	public static void main(String[] args){
		EmailService emailService = (EmailService)context.getBean("emailService");
		emailService.sendEmail("test1@mail.com","Howdy!! Test1");
		emailService.sendEmail("test2@mail.com","Hola,Test2");
	}

}
