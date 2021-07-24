package com.akash.maharana;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class GroupingObservables {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<Book>();
		bookList.add(new Book(101,"Reducing Stress",789.0));
		bookList.add(new Book(453,"Dealing with Diabetes",116.90));
		bookList.add(new Book(98,"Weight Loss in Three Steps",678.19));
		bookList.add(new Book(422,"Complier Design",987.0));
		bookList.add(new Book(645,"Programming Fundamentals",116.90));
		bookList.add(new Book(423,"Data Intensive Application",987.67));
		bookList.add(new Book(563,"Pair Programming",456.0));
		bookList.add(new Book(432,"Agile Methodologies",987.67));
		bookList.add(new Book(456,"Anti Corruption Groups",789.0));
		
		Observable<Book> bookObservable=Observable.fromIterable(bookList);
		
		bookObservable.groupBy(Book::getPrice)
			.flatMapSingle(e->e.toMultimap(key->e.getKey(),emp->emp.getName()))
			.subscribe(System.out::println);
		
		System.out.println();
		
		bookObservable.groupBy(Book::getPrice)
			.flatMapSingle(e->e.toList())
			.subscribe(System.out::println);
	}

}
