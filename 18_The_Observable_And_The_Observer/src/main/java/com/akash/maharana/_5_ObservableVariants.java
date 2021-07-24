package com.akash.maharana;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class _5_ObservableVariants {
	
	public static void main(String[] args) {
		Observable<String> source1=Observable.just("Akash","Bikash","Prakash");
		Observable<String> source2=Observable.empty();
		
		source2.first("Name").subscribe(System.out::println);
		Single.just("Akash").subscribe(System.out::println);
		
		source2.firstElement().subscribe(System.out::println,e->e.printStackTrace(),()->System.out.println("Completed"));
		
		Completable completable=Completable.complete();
		completable.subscribe(()->System.out.println("Completed"));
		
		Completable.fromRunnable(()->System.out.println("Some process executing"))
		.subscribe(()->System.out.println("The Process executed successfully"));
	}

}
