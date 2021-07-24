package com.akash.maharana;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure {

	public static void main(String[] args) {
		// Approach-1
		Flowable.range(1, 100000).map(e -> {
			System.out.println("Produced item is : " + e + " : " + Thread.currentThread().getName());
			return e;
		}).observeOn(Schedulers.io()).subscribe(e -> {
			sleep(100);
			System.out.println("Consume item is : " + e + " : " + Thread.currentThread().getName());
		});
		sleep(100000);

		// Approach-2
		Flowable.range(1, 100000).map(e -> {
			System.out.println("Produced item is : " + e + " : " + Thread.currentThread().getName());
			return e;
		}).observeOn(Schedulers.io()).subscribe(e -> new Subscriber<Integer>() {

			Subscription s;
			AtomicInteger count=new AtomicInteger(0);
			
			@Override
			public void onSubscribe(Subscription s) {
				this.s=s;
				System.out.println("Asking for 20 elements");
				s.request(20);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("The suscriber consumed item : "+t);
				if(count.getAndIncrement()%20==0) {
					System.out.println("Asking for next 20 items.");
					s.request(20);
				}
				sleep(100);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
			}

		});
		sleep(100000);

	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
