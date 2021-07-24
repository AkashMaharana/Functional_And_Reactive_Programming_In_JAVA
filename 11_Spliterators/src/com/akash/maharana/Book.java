package com.akash.maharana;

public class Book {

	private String author;
	private String name;
	private String genre;
	private double rating;

	public Book(String author, String name, String genre, double rating) {
		this.author = author;
		this.name = name;
		this.genre = genre;
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + ", genre=" + genre + ", rating=" + rating + "]";
	}

}
