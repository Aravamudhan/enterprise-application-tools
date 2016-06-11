package com.amudhan.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amudhan.springcore.contact.Address;

public class TestApp {
	public static void main(String[] args){
		
		ApplicationContext parentContext = new ClassPathXmlApplicationContext("springconfig.xml");
		/*This is an example for assigning a parent context and accessing a beans from there*/
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"testspringconfig.xml"},parentContext);
		TestBean testBeanConstructorProperties = (TestBean)context.getBean("testBeanConstructorProperties");
		TestBean testBeanByType = (TestBean)context.getBean("testBeanByType");
		
		System.out.println(testBeanConstructorProperties);
		System.out.println(testBeanByType);
		System.out.println("Parent of the current context "+context.getParent().getId());
		System.out.println("The team lead name is "+testBeanByType.getTeamLead().getEmployeeName());
		
		CollectionTestBean collectionTestBean=(CollectionTestBean)context.getBean("collectionTestBean");
		System.out.println(collectionTestBean);
		
		CollectionTestBean childBean=(CollectionTestBean)context.getBean("childBean");
		System.out.println("Merged bean "+childBean);
		
		Project project=(Project)context.getBean("project");
		System.out.println("The name of the manager injected by autowire "+project.getManager().getEmployeeName());
		System.out.println("Is project bean running "+project.isRunning());
		project.start();
		System.out.println("Is project bean running "+project.isRunning());
		project.stop();
		System.out.println("Is project bean running "+project.isRunning());
		System.out.println("Bean name injected in the project class "+project.getBeanName());
		System.out.println("Display name from the"
				+ "ApplicationContext injected in the project class "+project.getApplicationContext().getDisplayName());
		Address address = (Address)context.getBean("address");
		System.out.println("The autowired country name "+address.getCountry().getName());
	}

}
