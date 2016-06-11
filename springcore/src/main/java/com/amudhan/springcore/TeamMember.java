package com.amudhan.springcore;

public class TeamMember implements Employee {

	private String employeeName;
	private String greeting;
	private String teamName;
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public String getGreeting() {
		return greeting;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public String getEmployeeName() {
		return employeeName;
	}

}
