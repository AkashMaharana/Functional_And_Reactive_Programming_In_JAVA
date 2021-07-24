package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class MergeAndConcatObservable {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Observable<String> source1=Observable.just("Hi","Hello"); Observable<String>
		 * source2=Observable.just("Good","Morning");
		 * 
		 * Observable.merge(source1,source2).subscribe(System.out::println);
		 */
		
		Observable<String> source3=Observable.interval(1,TimeUnit.SECONDS).map(e->"src3 : "+e);
		Observable<String> source4=Observable.interval(1,TimeUnit.SECONDS).map(e->"src4 : "+e);
		
		//Observable.merge(source3,source4).subscribe(e->System.out.println("Received : "+e));
		
		Observable.concat(source3,source4).subscribe(e->System.out.println("Received : "+e));
		//source1.concatWith(source2);
		Thread.sleep(20000);
	}

}

