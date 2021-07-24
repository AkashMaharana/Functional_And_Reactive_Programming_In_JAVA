package com.akash.maharana;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class TypesOfSubjects {
	
	public static void main(String[] args) {
		Subject<String> subject=PublishSubject.create();
		subject.subscribe(e->System.out.println("Observer 1 : "+e));
		subject.onNext("Akash");
		subject.onNext("Swati");
		subject.onNext("Richi");
		subject.onNext("Rony");
		subject.subscribe(e->System.out.println("Observer 2 : "+e));
		subject.onNext("Janavi");
		subject.onNext("Vasudha");
		subject.onComplete();
		System.out.println("--------------------------------");
		Subject<String> subject1=ReplaySubject.create();
		subject1.subscribe(e->System.out.println("Observer 1 : "+e));
		subject1.onNext("Akash");
		subject1.onNext("Swati");
		subject1.onNext("Richi");
		subject1.onNext("Rony");
		subject1.subscribe(e->System.out.println("Observer 2 : "+e));
		subject1.onNext("Janavi");
		subject1.onNext("Vasudha");
		subject1.onComplete();
		System.out.println("----------------------------------");
		Subject<String> subject2=BehaviorSubject.create();
		subject2.subscribe(e->System.out.println("Observer 1 : "+e));
		subject2.onNext("Akash");
		subject2.onNext("Swati");
		subject2.onNext("Richi");
		subject2.onNext("Rony");
		subject2.subscribe(e->System.out.println("Observer 2 : "+e));
		subject2.onNext("Janavi");
		subject2.onNext("Vasudha");
		subject2.onComplete();
		System.out.println("-------------------------------------");
		Subject<String> subject3=AsyncSubject.create();
		subject3.subscribe(e->System.out.println("Observer 1 : "+e));
		subject3.onNext("Akash");
		subject3.onNext("Swati");
		subject3.onNext("Richi");
		subject3.onNext("Rony");
		subject3.subscribe(e->System.out.println("Observer 2 : "+e));
		subject3.onNext("Janavi");
		subject3.onNext("Vasudha");
		subject3.onComplete();
		System.out.println("-------------------------------------");
		//works only for a single subscriber. Once emitted the cache will be cleared by default
		Subject<String> subject4=UnicastSubject.create();
		subject4.subscribe(e->System.out.println("Observer 1 : "+e));
		subject4.onNext("Akash");
		subject4.onNext("Swati");
		subject4.onNext("Richi");
		subject4.onNext("Rony");
		subject4.subscribe(e->System.out.println("Observer 2 : "+e));
		subject4.onNext("Janavi");
		subject4.onNext("Vasudha");
		subject4.onComplete();
	}

}
