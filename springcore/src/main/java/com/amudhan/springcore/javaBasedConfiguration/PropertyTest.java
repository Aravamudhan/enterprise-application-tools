package com.amudhan.springcore.javaBasedConfiguration;

public class PropertyTest {
	private String name;
	private String message;
	public PropertyTest(){}
	
	public PropertyTest(String name,String message){
		this.name=name;
		this.message=message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PropertyTest [name=" + name + ", message=" + message + "]";
	}
}
