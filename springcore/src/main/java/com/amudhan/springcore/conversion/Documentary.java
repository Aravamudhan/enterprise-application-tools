package com.amudhan.springcore.conversion;

public class Documentary implements Medium {

	private String name;
	private String category;
	
	public Documentary(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Documentary [name=" + name + ", category=" + category + "]";
	}


}
