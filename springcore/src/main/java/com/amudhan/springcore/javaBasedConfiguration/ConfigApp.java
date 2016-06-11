package com.amudhan.springcore.javaBasedConfiguration;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp {
	private static AnnotationConfigApplicationContext context;
	public static void main(String[] args){
		//context = new AnnotationConfigApplicationContext(AppConfig.class);
		context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		/*Registering explicitly*/
		context.register(AppConfig.class);
		context.refresh();
		Set<Student> students = new HashSet<Student>();
		Student student1=(Student)context.getBean("student");
		student1.setName("Amudhan");
		student1.getDepartment().setName("IT");
		student1.getDepartment().getTeacher().setName("Mr.Bean");
		
		Student student2=(Student)context.getBean("newStudent");
		student2.setName("Sherlock");
		student2.getDepartment().setName("Science");
		student2.getDepartment().getTeacher().setName("Mr.Moriarty");
		
		students.add(student1);
		students.add(student2);
		
		for(Student s:students){
			System.out.println(s);
		}
		for(String s:context.getBeanDefinitionNames()){
			System.out.println(s);
		}
		DataSource dataSource =(DataSource)context.getBean("dataSource");
		System.out.println("The active profiles are :");
		for(String s:context.getEnvironment().getActiveProfiles()){
			System.out.println(s);
		}
		System.out.println("The current datasource is :"+dataSource.getDataSource());
		
		PropertyTest propertyTest1 = (PropertyTest)context.getBean("propertyTest");
		System.out.println(propertyTest1);
		
		/*System.out.println("-------------System properties----------------");
		System.getProperties().list(System.out);
		System.out.println("-------------Environment variables----------------");
		Set<Entry<String,String>> envprop=System.getenv().entrySet();
		for(Entry<String,String> e:envprop)
			System.out.println(e.getKey() +":"+ e.getValue());*/
		
	}

}
