package com.amudhan.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;

public class Project implements Lifecycle,BeanNameAware,ApplicationContextAware{ 
	
	private String name;
	/*BeanNameAware interface sets the bean name of the class that implements it.
	 * beanName property is used to set that name here*/
	private String beanName;
	/*The ApplicationContext that creates this bean is set in this property with the help of,
	ApplicationContextAware interface*/
	private ApplicationContext applicationContext;
	private Manager manager;
	private boolean isRunning;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@Override
	public void start() {
		isRunning=true;
		System.out.println("Project object start method");
		
	}
	@Override
	public void stop() {
		isRunning=false;
		System.out.println("Project object stop method");
		
	}
	@Override
	public boolean isRunning() {
		return isRunning;
	}
	@Override
	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
	public String getBeanName() {
		return beanName;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	

}
