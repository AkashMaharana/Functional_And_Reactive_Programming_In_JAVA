package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class _6_Dispose {
	
	private static final CompositeDisposable compositeDisposable=new CompositeDisposable();
	
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> source1=Observable.interval(1, TimeUnit.SECONDS);
		Disposable disposable=source1.subscribe(e->System.out.println("Observer1 : "+e));
		Thread.sleep(5000);
		disposable.dispose();
		source1.subscribe(e->System.out.println("Observer2 : "+e));
		Thread.sleep(10000);
		
		System.out.println("----------------------------");
		
		Disposable disposable1=source1.subscribe(e->System.out.println("Observer3 : "+e));
		Disposable disposable2=source1.subscribe(e->System.out.println("Observer4 : "+e));
		Thread.sleep(5000);
		compositeDisposable.addAll(disposable1,disposable2);
		compositeDisposable.dispose();
		Thread.sleep(10000);
		
	}

}
