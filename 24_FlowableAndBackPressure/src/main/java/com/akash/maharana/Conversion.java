package com.akash.maharana;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Conversion {
	
	public static void main(String[] args) throws InterruptedException {
		//Observable to Flowable to conversion
		Observable.range(0, 100000)
		.toFlowable(BackpressureStrategy.BUFFER)
		.observeOn(Schedulers.io())
		.subscribe(e->System.out.println(e+" "+Thread.currentThread().getName()));
		
		Thread.sleep(5000);
		
		//Flowable to Observable to conversion
		Flowable.range(0, 100000)
		.toObservable()
		.observeOn(Schedulers.io())
		.subscribe(e->System.out.println(e+" "+Thread.currentThread().getName()));
		
		Thread.sleep(5000);
	}

}
