package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SuscribeOnDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Observable.just("Pizza", "Pasta", "Burger", "Noodles", "Schewzan Noodles")
		.subscribeOn(Schedulers.computation())
		.map(e->e.toUpperCase())
		.subscribeOn(Schedulers.newThread())
		.filter(e->e.startsWith("P"))
		.subscribe(e->System.out.println(e));
		
		Thread.sleep(1000);
	}

}
