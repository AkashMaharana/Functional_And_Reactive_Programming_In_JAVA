package com.akash.maharana.stream;

public class Book {

	private String bookName;
	private String authorname;
	private double price;

	public Book() {
		
	}

	public Book(String bookName, String authorname, double price) {
		this.bookName = bookName;
		this.authorname = authorname;
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorname=" + authorname + ", price=" + price + "]";
	}

}
