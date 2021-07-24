package com.akash.maharana.observer.pattern;

public class User implements Observer {

	private String name;

	public User(String name, SubjectLibrary subjectLibrary) {
		this.name = name;
		subjectLibrary.subscribeObserver(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String availability) {
		System.out.println("Hello,"+this.name+" we are glad to notify that the requetsed book is available now.");

	}

}
