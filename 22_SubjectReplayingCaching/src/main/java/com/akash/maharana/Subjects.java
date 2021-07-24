package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects {
	
	public static void main(String[] args) throws InterruptedException {
		Observable<Integer> source1=Observable.just(5,10,15,20).subscribeOn(Schedulers.computation());
		Observable<Integer> source2=Observable.just(25,30,35,40).subscribeOn(Schedulers.computation());
		
		//Multiple observable with one observer
		Subject<Object> subject=PublishSubject.create();
		subject.subscribe(e->System.out.println(e));
		
		source1.subscribe(subject);
		source2.subscribe(subject);
		
		Thread.sleep(9000);
		
		//One observable with multiple observer
		Observable<Integer> source3=Observable.just(5,10,15,20).subscribeOn(Schedulers.computation());
		
		Subject<Object> subject1=PublishSubject.create();
		subject1.subscribe(e->System.out.println(e));
		subject1.subscribe(e->System.out.println(e));
		
		source3.subscribe(subject1);
		
		Thread.sleep(9000);
	}

}
