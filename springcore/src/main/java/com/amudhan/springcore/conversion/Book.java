package com.amudhan.springcore.conversion;


public class Book{
	
	public Book(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}
	private String name;
	private String category;
	
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
		return "Book [name=" + name + ", category=" + category + "]";
	}
}
