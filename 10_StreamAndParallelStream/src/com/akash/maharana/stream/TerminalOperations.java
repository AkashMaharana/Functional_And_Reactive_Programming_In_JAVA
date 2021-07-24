package com.akash.maharana.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {
	
	public static void main(String[] args) {
		List<Book> bookList=new ArrayList<>();
		bookList.add(new Book("Programmin Pearls","Akash Maharana",696.98));
		bookList.add(new Book("Introduction to Kafka","Jose Paul",789.00));
		bookList.add(new Book("Tech Dummies","Narendra",458.56));
		bookList.add(new Book("Date Intensive Application","Google Press",1600.89));
		bookList.add(new Book("Reactive Programmings","Dilip Sundaraj",999.99));
		
		Double reduceValue = bookList.stream().map(Book::getPrice).reduce(0.0,(a,b)->a+b);
		System.out.println(reduceValue);
		
		OptionalDouble averageValue = bookList.stream().mapToDouble(Book::getPrice).average();
		System.out.println(averageValue.getAsDouble());
		
		IntStream intStream=IntStream.of(1,3,5,7);
		Stream<Integer> boxedInt=intStream.boxed();
		intStream.mapToObj(value->value);
	}

}
