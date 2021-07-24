package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadSchedulersDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// New Thread Schedulers
		Observable<String> source2 = Observable.just("Pizza", "Pasta", "Burger", "Farmhouse", "Spagetti")
				.subscribeOn(Schedulers.newThread());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		source2.subscribe(e -> compute());
		Thread.sleep(5000);
	}

	private static void compute() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Computation done by : " + Thread.currentThread().getName());
	}

}
