package com.amudhan.springcore;

public class TeamLead implements Employee {

	private String employeeName;
	private String greeting;
	private String teamName;
	
	private TeamLead(){
		
	}
	private TeamLead(String employeeName,String greeting,String teamName){
		this.employeeName=employeeName;
		this.greeting=greeting;
		this.teamName=teamName;
	}
	/*This is static factory method. 
	 *The reason for making it static is sometimes, we might not even have a bean/class to begin with.
	 *By making the method static, it can be accessed with having to create of this class.*/
	public static TeamLead createInstance(String employeeName,String greeting,String teamName){
		return new TeamLead(employeeName,greeting,teamName);
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public String toString() {
		return "TeamLead [employeeName=" + employeeName + ", greeting=" + greeting + ", teamName=" + teamName + "]";
	}
	

}
