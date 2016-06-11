package com.amudhan.springcore;

import java.beans.ConstructorProperties;

public class TestBean {
	private String name;
	private String country;
	private int age;
	private TeamLead teamLead;
	@ConstructorProperties({"name","country"})
	public TestBean(String name,String country){
		this.name=name;
		this.country=country;
		this.age=0;
	}
	
	public TestBean(String name,int age){
		this.name=name;
		this.country="Not specified";
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public TeamLead getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(TeamLead teamLead) {
		this.teamLead = teamLead;
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", country=" + country + ", age = "+age+"]";
	}
}
