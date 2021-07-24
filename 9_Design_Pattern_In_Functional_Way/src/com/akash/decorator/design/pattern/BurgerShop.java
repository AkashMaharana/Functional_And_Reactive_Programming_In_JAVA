package com.akash.decorator.design.pattern;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BurgerShop {
	
	private Function<Burger,Burger> decoration;
	
	public BurgerShop(UnaryOperator<Burger> decoration) {
		this.decoration=decoration;
	}
	
	public Burger use(Burger baseBurger) {
		System.out.println("Base Burger : "+baseBurger);
		return decoration.apply(baseBurger);
	}
	
	

}
