package com.akash.maharana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;

public class CustomCollector {
	
	public static void main(String[] args) {
		List<Integer> numbers=new ArrayList<>();
		for(int i=0;i<10;i++) {
			numbers.add(new Random().nextInt(100)*10);
		}
		Collector<Integer,List<Integer>,List<Integer>> toListCollector=Collector.of(ArrayList::new, //Supplier
				(list,element)->list.add(element), // BiConsumer : Accumulator
				(list1,list2)->{ // BiFunction : Combiner
					list1.addAll(list2);
					return list1;
				}, 
				Collector.Characteristics.IDENTITY_FINISH
				);
		
		List<Integer> collect = numbers.stream().collect(toListCollector);
		collect.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		Collector<Integer,List<Integer>,List<Integer>> toListSortedCollector=Collector.of(ArrayList::new, //Supplier
				(list,element)->list.add(element), // BiConsumer : Accumulator
				(list1,list2)->{ // BiFunction : Combiner
					list1.addAll(list2);
					return list1;
				},
				(list)->{
					Collections.sort(list);
					return list;
				},
				Collector.Characteristics.UNORDERED
				);
		
		List<Integer> sortedCollection = numbers.stream().collect(toListSortedCollector);
		sortedCollection.forEach(System.out::println);
	}

}
