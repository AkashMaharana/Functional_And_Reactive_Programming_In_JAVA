package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationSchedulersDemo {

	public static void main(String[] args) throws InterruptedException {
		// Computation Scheduler
		Observable<String> source = Observable.just("Pizza", "Pasta", "Burger", "Farmhouse", "Spagetti")
				.subscribeOn(Schedulers.computation());
		source.subscribe(e -> compute());
		source.subscribe(e -> compute());
		source.subscribe(e -> compute());
		source.subscribe(e -> compute());
		source.subscribe(e -> compute());
		Thread.sleep(5000);

		System.out.println();

		// IO Schedulers
		Observable<String> source1 = Observable.just("Pizza", "Pasta", "Burger", "Farmhouse", "Spagetti")
				.subscribeOn(Schedulers.io());
		source1.subscribe(e -> compute());
		source1.subscribe(e -> compute());
		source1.subscribe(e -> compute());
		source1.subscribe(e -> compute());
		source1.subscribe(e -> compute());
		Thread.sleep(5000);

		System.out.println();

		// New Thread Schedulers
		Observable<String> source2 = Observable.just("Pizza", "Pasta", "Burger", "Farmhouse", "Spagetti")
				.subscribeOn(Schedulers.newThread());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		Thread.sleep(5000);

		System.out.println();

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
