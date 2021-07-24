package com.akash.iterator.design.pattern;

public class IteratorPattern {
	
	public static void main(String[] args) {
		Object[] elements=new Object[] {1,2,3,4,5};
		MyArrayList list=new MyArrayList(elements);
		list.forEach(System.out::println);
	}

}
