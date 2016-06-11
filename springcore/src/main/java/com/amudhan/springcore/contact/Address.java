package com.amudhan.springcore.contact;

import org.springframework.beans.factory.annotation.Autowired;

public class Address {
	private String town;
	private String state;
	@Autowired
	@CountryQualifier(name="2")
	//@Qualifier("4")
	private Country country;
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

}
