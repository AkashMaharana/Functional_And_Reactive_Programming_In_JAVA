package com.akash.maharana;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class AmbigousOperator {
	
	public static void main(String[] args) throws InterruptedException {
		Observable<String> source1=Observable.interval(1, TimeUnit.SECONDS).map(e->"Source1 : "+e).take(10);
		Observable<String> source2=Observable.interval(10, TimeUnit.MILLISECONDS).map(e->"Source2 : "+e).take(10);
		
		Observable.amb(Arrays.asList(source1,source2)).subscribe(System.out::println);
		
		Thread.sleep(10000);
	}

}
