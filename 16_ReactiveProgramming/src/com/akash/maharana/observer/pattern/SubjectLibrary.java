package com.akash.maharana.observer.pattern;

public interface SubjectLibrary {
	
	public void subscribeObserver(Observer observer);
	public void unsubscribeObserver(Observer observer);
	public void notifyObserver();

}
