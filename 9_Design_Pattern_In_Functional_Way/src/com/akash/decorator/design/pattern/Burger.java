package com.akash.decorator.design.pattern;

public class Burger {

	private String burgerType;

	public Burger() {

	}
	
	public String getBurgerType() {
		return burgerType;
	}

	public void setBurgerType(String burgerType) {
		this.burgerType = burgerType;
	}

	private Burger(String type) {
		this.burgerType = type;
	}

	public Burger addVeggies() {
		return new Burger("Veg Burger");
	}

	public Burger addChese() {
		return new Burger("Chese Burger");
	}

	@Override
	public String toString() {
		return "Burger [burgerType=" + burgerType + "]";
	}

}
