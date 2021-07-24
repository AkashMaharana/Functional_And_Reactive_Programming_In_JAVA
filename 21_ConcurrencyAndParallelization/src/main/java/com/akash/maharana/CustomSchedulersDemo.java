package com.akash.maharana;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomSchedulersDemo {
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(10);
		Scheduler scheduler=Schedulers.from(es);
		Observable<String> source=Observable.just("Pasta","Pizza","Burger","Farmhouse","Noodles")
									.subscribeOn(scheduler)
									.doFinally(es::shutdown);
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
		source.subscribe(e->compute());
	}
	
	private static void compute() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by : " + Thread.currentThread().getName());
	}
}
