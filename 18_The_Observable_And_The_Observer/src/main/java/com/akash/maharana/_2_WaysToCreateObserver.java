package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;

public class _2_WaysToCreateObserver {
	
	public static void main(String[] args) {
		Observable<String> source=Observable.just("Akash","Bikash");
		
		//onNext,onError,onComplete
		source.subscribe(System.out::println,Throwable::printStackTrace,()->System.out.println("Completed"));
		System.out.println("-------------------");
		
		//onNext,onError
		source.subscribe(System.out::println,Throwable::printStackTrace);
		
		//onNext
		source.subscribe(System.out::println);
		
		
	}

}
