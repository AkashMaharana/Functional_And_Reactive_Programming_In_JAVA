package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
	
	public static void main(String[] args) {
		Observable<String> source=Observable.create(
				e->{
					e.onNext("hello");
					e.onNext("Hi");
				}
		);
		source.subscribe(e->System.out.println(e));
		
	}

}
