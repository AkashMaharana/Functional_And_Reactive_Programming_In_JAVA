package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IOSchedulersDemo {
	
	public static void main(String[] args) throws InterruptedException {
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

		
	}

	private static void compute() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by : " + Thread.currentThread().getName());
	}

}
