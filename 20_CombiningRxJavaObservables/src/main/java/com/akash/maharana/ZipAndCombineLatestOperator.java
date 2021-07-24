package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombineLatestOperator {

	public static void main(String[] args) throws InterruptedException {
		Observable<String> source1=Observable.interval(200, TimeUnit.MILLISECONDS).map(e->"Source1 : "+e).take(10);
		Observable<String> source2=Observable.interval(1, TimeUnit.SECONDS).map(e->"Source2 : "+e).take(10);
		
		//Observable.zip(source1,source2,(s1,s2)->"Source1 : "+s1+" Source2 : "+s2).subscribe(System.out::println);
		
		Observable.combineLatest(source1,source2,(s1,s2)->"Source1 : "+s1+" Source2 : "+s2).subscribe(System.out::println);
		
		Thread.sleep(10000);
	}
}
