package com.akash.maharana;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class _3_ColdObservable {
	
	// Cold observable are always emits data from the beginning only. When we will add a new observer to an existing observable 
	// it will start reading from the beginning only. While in case of hot observable new observers will start from the ponit of 
	// Joining only.
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("Akash");
		list.add("Bikash");
		list.add("Prakash");
		
		Observable<String> source=Observable.fromIterable(list);
		source.subscribe(System.out::println);
		System.out.println();
		list=updateList(list);
		source.subscribe(System.out::println);
	}
	
	private static List<String> updateList(List<String> list){
		list.add("Rakesh");
		return list;
	}

}
