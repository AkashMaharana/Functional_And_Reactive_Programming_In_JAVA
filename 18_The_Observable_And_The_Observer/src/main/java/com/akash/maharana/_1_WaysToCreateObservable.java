package com.akash.maharana;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class _1_WaysToCreateObservable {
	
	public static void main(String[] args) {
		//create
		Observable<String> source=Observable.create(
				e->{
					e.onNext("Hello");
					e.onNext("Hi");
					e.onComplete();
				}
		);
		source.subscribe(e->System.out.println(e));
		
		//just
		Observable<Integer> source1=Observable.just(1,2,3);
		source1.subscribe(e->System.out.println(e));
		
		//fromIterable
		List<String> list=new ArrayList<>();
		list.add("Akash");
		list.add("Bikash");
		list.add("Jhakas");
		Observable<String> source2=Observable.fromIterable(list);
		source2.subscribe(e->System.out.println(e));
		
		//range
		Observable<Integer> source3 = Observable.range(5, 10);
		source3.subscribe(e->System.out.println(e));
		
		//defer
		Observable<String> deferObservable=Observable.defer(()->Observable.fromIterable(list));
		deferObservable.subscribe(System.out::println);
		list.add("Rakesh");
		deferObservable.subscribe(System.out::println);
		
		//Observable.interval()
		//Observable.future()
		//Observable.empty()
		//Observable.never()
		//Observable.error(exception)
		//Observable.fromCallable()
		
	}
}
