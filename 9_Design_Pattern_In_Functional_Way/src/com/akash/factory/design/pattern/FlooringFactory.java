package com.akash.factory.design.pattern;

import java.util.function.Supplier;

public class FlooringFactory {
	
	public static Flooring getFlooring(int minimumTemp,int maximumTemp) {
		
		Supplier<Flooring> flooring;  
		
		if(minimumTemp<=5 && maximumTemp<=20) {
			flooring=WoodenFlooring::new;
		}
		else if(minimumTemp<=5 && maximumTemp>=45) {
			flooring=CorkFlooring::new;
		}
		else {
			flooring=ConcreteFlooring::new;
		}
		return flooring.get();
	}
}
