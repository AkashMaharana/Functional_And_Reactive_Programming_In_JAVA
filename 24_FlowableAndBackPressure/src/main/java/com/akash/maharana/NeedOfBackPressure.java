package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NeedOfBackPressure {
	
	public static void main(String[] args) {
		Observable.range(1, 100000)
		.map(e->{
			System.out.println("Produced item is : "+e+" : "+Thread.currentThread().getName());
			return e;
		})
		.observeOn(Schedulers.io())
		.subscribe(e->{
			sleep(100);
			System.out.println("Consume item is : "+e+" : "+Thread.currentThread().getName());
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
