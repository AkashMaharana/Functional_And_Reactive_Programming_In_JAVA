package com.akash.maharana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<Book>();
		bookList.add(new Book(101,"Reducing Stress",789.0));
		bookList.add(new Book(453,"Dealing with Diabetes",397.45));
		bookList.add(new Book(98,"Weight Loss in Three Steps",678.19));
		bookList.add(new Book(422,"Complier Design",987.0));
		bookList.add(new Book(645,"Programming Fundamentals",116.90));
		bookList.add(new Book(423,"Data Intensive Application",110.0));
		bookList.add(new Book(563,"Pair Programming",456.0));
		bookList.add(new Book(432,"Agile Methodologies",987.67));
		bookList.add(new Book(456,"Anti Corruption Groups",313.56));
		
		Observable<Book> bookObservable=Observable.fromIterable(bookList);
		bookObservable.subscribe(System.out::println);
		
		System.out.println();
		
		bookObservable.filter(book->book.getPrice()>500.0).map(Book::getName).subscribe(System.out::println);
		
		System.out.println();
		
		bookObservable.sorted((e1,e2)->e1.getName()
				.compareTo(e2.getName()))
				.map(Book::getName)
				/*
				 * .take(2) .toList()
				 */
				.subscribe(System.out::println);
		
		System.out.println();
		
		Observable<Integer> expenses=Observable.fromIterable(Arrays.asList(12,56,33,63,13,52));
		expenses.scan((a,b)->a+b).subscribe(System.out::println);
		
		System.out.println();
		expenses.reduce((a,b)->a+b).subscribe(System.out::println);
	}
}
