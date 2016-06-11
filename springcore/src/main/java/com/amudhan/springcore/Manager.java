package com.amudhan.springcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Manager implements Employee,InitializingBean,DisposableBean{

	private String employeeName;
	private String greeting;
	
	@Override
	public String getEmployeeName() {
		return employeeName;
	}
	/*employeeName value is injected by setter based injection*/
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	/*If this method is present, it will be called just after this bean is initialized.*/ 
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Manager employee bean is initialized");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Manager employee bean is about to be destroyed");
		
	}
}
