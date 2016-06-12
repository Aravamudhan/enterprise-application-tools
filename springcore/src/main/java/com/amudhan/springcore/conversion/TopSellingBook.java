package com.amudhan.springcore.conversion;

public class TopSellingBook {
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "TopSellingBook [book=" + book + "]";
	}
}
