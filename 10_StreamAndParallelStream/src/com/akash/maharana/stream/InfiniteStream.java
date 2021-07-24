package com.akash.maharana.stream;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		Stream.iterate(0,i->i+1)
		.limit(15)
		.forEach(System.out::println);
		
		Stream.generate(Random::new).forEach(System.out::println);
	}
	
}
