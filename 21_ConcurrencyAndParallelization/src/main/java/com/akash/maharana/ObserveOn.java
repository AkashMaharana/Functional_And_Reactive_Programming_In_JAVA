package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {
	
	public static void main(String[] args) throws InterruptedException {
		Observable.just("Pizza", "Pasta", "Burger", "Noodles", "Schewzan Noodles")
		.subscribeOn(Schedulers.computation())
		.map(e->e.toUpperCase())
		.doOnNext(e->System.out.println(Thread.currentThread().getName()))
		.observeOn(Schedulers.newThread())
		.filter(e->e.startsWith("P"))
		.observeOn(Schedulers.io())
		.subscribe(e->System.out.println(e+" printed by "+Thread.currentThread().getName()));
		
		Thread.sleep(6000);
	}

}
