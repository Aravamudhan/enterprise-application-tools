package com.amudhan.springcore.javaBasedConfiguration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages="com.amudhan.springcore.javaBasedConfiguration")
@PropertySource("classpath:properties/name.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean(name={"newStudent","oldStudent","student"})
	@Description("A student bean")
	@Scope("prototype")
	/*The bean name will be the method name. 
	 *The bean created in the container will have the name "student"*/
	public Student student(){
		return new Student();
		/*Another way of injecting department bean into student bean*/
		/*This can be done provided an appropriate construcor is present and most importantly,
		 *the bean being referenced is being created by @Bean, not by @Component */
		/*return new Student(department());*/
	}
	@Bean
	@Description("Creates a department bean and injects an already created teacher bean into it.")
	@Scope("prototype")
	public Department department(Teacher teacher){
		return new Department(teacher);
	}
	@Bean
	@Scope("prototype")
	public PropertyTest propertyTest(MessageSource messageSource){
		String name=env.getProperty("propertyTest.name");
		//System.out.println(messageSource.toString());
		return new PropertyTest(name,messageSource.getMessage("greeting",
								new Object[]{name,env.getProperty("propertyTest.frenchGreeting")}, 
								Locale.FRENCH));
	}
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource resources= new ResourceBundleMessageSource();
		resources.setBasenames("properties/errormessages","properties/message");
		return resources;
	}
}
