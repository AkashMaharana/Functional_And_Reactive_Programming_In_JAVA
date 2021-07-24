package com.akash.maharana.observer.pattern;

public class ObserverPattern {
	
	public static void main(String[] args) {
		Book book=new Book("Algorithms","Computer Programming","Dan Brown",90.90,"Soldout");
		User user1=new User("Akash",book);
		User user2=new User("Swati",book);
		
		System.out.println(book.getInStock());
		book.setInStock("In Stock");
	}

}
