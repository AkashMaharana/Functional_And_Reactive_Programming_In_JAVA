package com.akash.maharana.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<>();
		bookList.add(new Book("Programmin Pearls","Akash Maharana",696.98));
		bookList.add(new Book("Introduction to Kafka","Jose Paul",789.00));
		bookList.add(new Book("Tech Dummies","Narendra",458.56));
		bookList.add(new Book("Date Intensive Application","Google Press",1600.89));
		bookList.add(new Book("Reactive Programmings","Dilip Sundaraj",999.99));
		
		List<Book> filteredList1 = bookList.stream()
										.filter(book->book.getPrice()>500.00)
										.collect(Collectors.toList());
		filteredList1.forEach(System.out::println);
		System.out.println();
		List<Book> filteredList2 = bookList.parallelStream()
				.filter(book->book.getPrice()>500.00)
				.collect(Collectors.toList());
		filteredList2.forEach(System.out::println);
	}

}
