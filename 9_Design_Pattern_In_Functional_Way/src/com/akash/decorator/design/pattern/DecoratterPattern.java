package com.akash.decorator.design.pattern;

public class DecoratterPattern {

	public static void main(String[] args) {
		Burger vegBurger = new BurgerShop(Burger::addVeggies).use(new Burger());
		System.out.println(vegBurger);

		Burger cheeseBurger = new BurgerShop(Burger::addChese)
				.use(new BurgerShop(Burger::addVeggies).use(new Burger()));
		System.out.println(cheeseBurger);
	}

}
