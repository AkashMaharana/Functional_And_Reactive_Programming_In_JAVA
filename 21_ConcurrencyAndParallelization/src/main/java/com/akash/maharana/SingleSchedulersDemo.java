package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleSchedulersDemo {
	public static void main(String[] args) throws InterruptedException {
		// Single Schedulers
		Observable<String> source3 = Observable.just("Pizza", "Pasta", "Burger", "Farmhouse", "Spagetti")
				.subscribeOn(Schedulers.single());
		source3.subscribe(e -> compute());
		source3.subscribe(e -> compute());
		source3.subscribe(e -> compute());
		source3.subscribe(e -> compute());
		source3.subscribe(e -> compute());
		Thread.sleep(5000);
	}

	private static void compute() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by : " + Thread.currentThread().getName());
	}
}
