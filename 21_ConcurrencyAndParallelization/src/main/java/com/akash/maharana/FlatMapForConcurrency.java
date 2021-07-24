package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlatMapForConcurrency {
	
	public static void main(String[] args) throws InterruptedException {
		Observable.just("Pasta","Pizza","Burger","Sandwich","Mocktails")
		.flatMap(e->Observable.just(e)
				.subscribeOn(Schedulers.computation())
				.map(str->compute(str)))
		.subscribe(System.out::println);
		Thread.sleep(7000);
	}
	
	private static String compute(String input) {
		String output=input+" printed by "+Thread.currentThread().getName();
		return output;
	}

}
