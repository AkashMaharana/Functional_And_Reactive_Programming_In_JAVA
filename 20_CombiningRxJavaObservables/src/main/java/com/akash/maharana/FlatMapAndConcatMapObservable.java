package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;

public class FlatMapAndConcatMapObservable {
	
	public static void main(String[] args) {
		Observable<String> input=Observable.just("Hi","Hello","Hey");
		input.flatMap(e->Observable.fromArray(e.split(""))).distinct().subscribe(System.out::println);
	}

}
