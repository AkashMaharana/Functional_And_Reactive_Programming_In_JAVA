package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class _4_ConnectableObservables {
	
	// It converts a cold observable to a hot one.
	
	public static void main(String[] args)  throws InterruptedException{
		@NonNull
		ConnectableObservable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
		source.connect();
		source.subscribe(System.out::println);
		Thread.sleep(10000);
		source.subscribe(System.out::println);
		Thread.sleep(10000);
	}

}
