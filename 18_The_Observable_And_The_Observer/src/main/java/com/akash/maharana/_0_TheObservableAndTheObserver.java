package com.akash.maharana;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class _0_TheObservableAndTheObserver {
	
	public static void main(String[] args) {
		Observable<Integer> source=new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>(){

			public void subscribe(ObservableEmitter<Integer> emitter) throws Throwable {
				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onComplete();
				} catch(Throwable e) {
					emitter.onError(e);
				}
			}
			
		});
		
		Observer<Integer> observer=new Observer<Integer>() {

			public void onSubscribe(Disposable d) {
				System.out.println("Suscribed");
			}

			public void onNext(Integer t) {
				System.out.println("On next : "+t);
			}

			public void onError(Throwable e) {
				e.printStackTrace();
			}

			public void onComplete() {
				System.out.println("Completed");
			}
			
		};
		
		source.subscribe(observer);
	}

}
