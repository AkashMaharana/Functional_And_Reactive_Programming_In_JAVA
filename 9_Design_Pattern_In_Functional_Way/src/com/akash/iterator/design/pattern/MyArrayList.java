package com.akash.iterator.design.pattern;

import java.util.function.Consumer;

public class MyArrayList {
	
	private Object[] elements;
	
	public MyArrayList(Object[] elements) {
		this.elements=elements;
	}
	
	public void forEach(Consumer<Object> action) {
		for(int i=0;i<this.elements.length;i++) {
			action.accept(this.elements[i]);
		}
	}

}
