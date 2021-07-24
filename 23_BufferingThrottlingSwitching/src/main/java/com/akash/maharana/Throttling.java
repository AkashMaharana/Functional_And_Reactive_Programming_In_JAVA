package com.akash.maharana;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Throttling {

	public static void main(String[] args) {
		Observable<String> source = Observable.create(emitter -> {
			emitter.onNext("A");
			Thread.sleep(200);
			emitter.onNext("B");
			Thread.sleep(100);
			emitter.onNext("C");
			Thread.sleep(400);
			emitter.onNext("D");
			Thread.sleep(300);
			emitter.onNext("E");
			Thread.sleep(800);
			emitter.onNext("F");
			Thread.sleep(900);
			emitter.onNext("G");
			Thread.sleep(600);
			emitter.onNext("H");
			Thread.sleep(1000);
			emitter.onNext("I");
			emitter.onComplete();
		});

		source.throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(item -> System.out.println("onNext item : " + item),
				Throwable::printStackTrace, () -> System.out.println("Throttle First onComplete"));
		System.out.println();
		source.throttleLast(1000, TimeUnit.MILLISECONDS).subscribe(item -> System.out.println("onNext item : " + item),
				Throwable::printStackTrace, () -> System.out.println("Throttle Last onComplete"));
		System.out.println();
		source.sample(1000, TimeUnit.MILLISECONDS).subscribe(item -> System.out.println("onNext item : " + item),
				Throwable::printStackTrace, () -> System.out.println("Sample onComplete"));
		System.out.println();
		source.throttleWithTimeout(1000, TimeUnit.MILLISECONDS).subscribe(item -> System.out.println("onNext item : " + item),
				Throwable::printStackTrace, () -> System.out.println("Sample onComplete"));
		System.out.println();
		source.debounce(1000, TimeUnit.MILLISECONDS).subscribe(item -> System.out.println("onNext item : " + item),
				Throwable::printStackTrace, () -> System.out.println("Sample onComplete"));
	}

}
