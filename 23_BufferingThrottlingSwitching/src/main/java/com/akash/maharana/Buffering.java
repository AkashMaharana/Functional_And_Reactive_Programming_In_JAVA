package com.akash.maharana;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Buffering {
	
	public static void main(String[] args) throws InterruptedException {
		Observable.range(1, 30).buffer(4).subscribe(System.out::println);
		System.out.println();
		
		Observable.range(1, 30).buffer(4,HashSet::new).subscribe(System.out::println);
		System.out.println();
		
		Observable.range(1, 30).buffer(4,5).subscribe(System.out::println);
		System.out.println();
		
		Observable.interval(500, TimeUnit.MILLISECONDS)
		.buffer(1,TimeUnit.SECONDS,2)
		.subscribe(System.out::println);
		Thread.sleep(8000);
		
		Observable<Long> interval=Observable.interval(1,TimeUnit.SECONDS);
		Observable.interval(500, TimeUnit.MILLISECONDS)
		.buffer(interval)
		.subscribe(System.out::println);
		Thread.sleep(8000);
		
		Observable<Long> interval1=Observable.interval(1,TimeUnit.SECONDS);
		Observable.interval(500, TimeUnit.MILLISECONDS)
		.window(interval1)
		.subscribe(System.out::println);
		Thread.sleep(8000);
	}

}
