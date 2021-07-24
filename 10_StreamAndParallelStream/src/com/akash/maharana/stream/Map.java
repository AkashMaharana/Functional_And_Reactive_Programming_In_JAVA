package com.akash.maharana.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<>();
		bookList.add(new Book("Programmin Pearls","Akash Maharana",696.98));
		bookList.add(new Book("Introduction to Kafka","Jose Paul",789.00));
		bookList.add(new Book("Tech Dummies","Narendra",458.56));
		bookList.add(new Book("Date Intensive Application","Google Press",1600.89));
		bookList.add(new Book("Reactive Programmings","Dilip Sundaraj",999.99));
		
		bookList.stream().map(Book::getAuthorname).collect(Collectors.toList());
	}

}
