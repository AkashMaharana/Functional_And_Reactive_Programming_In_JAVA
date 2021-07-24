package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Replaying {
	
	public static void main(String[] args) throws InterruptedException {
		//replay(1) : will start taking one previous value from the latest value 
		//replay(1,TimeUnit.SECONDS) : with time interval
		//replay(1,1,TimeUnit.SECONDS) : with time and buffer parameter
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).replay().autoConnect();
		source.subscribe(e->System.out.println("Observer 1 : "+e));
		Thread.sleep(5000);
		source.subscribe(e->System.out.println("Observer 2 : "+e));
		Thread.sleep(3000);
	}

}
