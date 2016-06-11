package com.amudhan.springcore;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class EmployeeDetails {
	
	private Employee employee;
	private String welcomeNote;
	private List<String> projects;
	private String greeting;
	
	@PostConstruct
	public void init(){
		System.out.println("EmployeDetails bean is initialized");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("EmployeDetails bean is about to be destroyed");
	}
	public EmployeeDetails(){
		
	}
	/*Employee is injected through constructor based injection*/
	public EmployeeDetails(Employee employee){
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getWelcomeNote() {
		return welcomeNote;
	}
	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}
	public void greetEmployee(){
			System.out.println(welcomeNote);
	}
	/*Notice, the object 'employee' has not been created explicitly anywhere in this class
	It is injected through construcor based injection. This enables this class to call its public methods*/
	public String getEmployeeName() {
		return employee.getEmployeeName();
	}
	public List<String> getProjects() {
		return projects;
	}
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getEmployeeGreeting(){
		return employee.getGreeting();
	}
	
}
