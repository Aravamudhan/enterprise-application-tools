package com.amudhan.springcore.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationBeanConfig {
	
	@Bean
	public Person person(){
		return new Person();
	}
	
	@Bean
	public Contact contact(){
		return new Contact();
	}
	
	@Bean
	public PersonValidator PersonValidator(ContactValidator contactValidator){
		return new PersonValidator(contactValidator);
	}
	
	@Bean
	public ContactValidator ContactValidator(){
		return new ContactValidator();
	}

}
