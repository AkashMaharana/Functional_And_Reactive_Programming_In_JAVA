package com.akash.maharana;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayingWithList {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<>();
		bookList.add(new Book("Programmin Pearls","Akash Maharana",696.98));
		bookList.add(new Book("Introduction to Kafka","Jose Paul",789.00));
		bookList.add(new Book("Tech Dummies","Narendra",458.56));
		bookList.add(new Book("Date Intensive Application","Google Press",1600.89));
		bookList.add(new Book("Reactive Programmings","Dilip Sundaraj",999.99));
		
		bookList.forEach(System.out::println);
		System.out.println();
		
		/*
		 * We can use natural order only when the objects are of comparable type.
		 * bookList.sort(Comparator.naturalOrder());
		 */
		
		bookList.sort((book1,book2)->
			book1.getAuthorname().compareTo(book2.getAuthorname()));
		bookList.forEach(System.out::println);
		System.out.println();
		
		bookList.stream().filter(book->!book.getAuthorname().startsWith("A")).forEach(System.out::println);
		System.out.println();
		
		bookList.stream().map(Book::getAuthorname).forEach(System.out::println);
		System.out.println();
		
		Optional<String> names=bookList.stream().map(Book::getAuthorname).reduce((name1,name2)->name1+" | "+name2);
		if(names.isPresent()) {
			System.out.println(names.get());
		}
		System.out.println();
	}

}
