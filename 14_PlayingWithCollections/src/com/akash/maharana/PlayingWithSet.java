package com.akash.maharana;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PlayingWithSet {
	
	public static void main(String[] args) {
		Set<Integer> input=new HashSet<>();
		for(int i=0;i<10;i++) {
			input.add(new Random().nextInt(100)*10);
		}
		
		input.stream().filter(number->number%2==0).forEach(System.out::println);
		System.out.println();
		
		input.stream().sorted().forEach(System.out::println);
		System.out.println();
		
		input.stream().map(number->Double.valueOf(number)).forEach(System.out::println);
		System.out.println();
		
		Set<Double> doubleNumbers=input.stream().map(number->Double.valueOf(number)).collect(Collectors.toSet());
		doubleNumbers.forEach(System.out::println);
		System.out.println();
		
		TreeSet<Integer> sortedCollection=input.stream().collect(Collectors.toCollection(TreeSet::new));
		sortedCollection.forEach(System.out::println);
		System.out.println();
		
		int sum = input.stream().mapToInt(inputNumber->inputNumber).sum();
		System.out.println(sum);
		System.out.println();
	}

}
