package com.akash.maharana;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class AddingEmissionUsingSubject {
	
	public static void main(String[] args) {
		PublishSubject<String> subject=PublishSubject.create();
		Subject<String> serialized=subject.toSerialized();
		serialized.subscribe(System.out::println);
		serialized.subscribe(e->System.out.println("Observer 2 : "+e));
		serialized.onNext("Akash");
		serialized.onNext("Swati");
		serialized.onNext("Richi");
		serialized.onNext("Rony");
		serialized.onComplete();
	}

}
