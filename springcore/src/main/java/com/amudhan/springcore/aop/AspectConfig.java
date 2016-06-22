package com.amudhan.springcore.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.amudhan.springcore.validation.Contact;

@Configuration
@ComponentScan(basePackages="com.amudhan.springcore.aop")
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public Contact contact(){
		Contact contact = new Contact();
		return contact;
	}

}
