package com.akash.fluent.design.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Order {

	private List<String> cart = new ArrayList<>();
	private String address = "";

	public Order() {

	}

	public Order(List<String> cart, String address) {
		this.cart = cart;
		this.address = address;
	}

	public static void place(UnaryOperator<Order> function) {
		Order order = new Order();
		order = function.apply(order);
		System.out.println("Order Placed. Order Deatils : " + order);
	}

	public Order addItem(String item) {
		cart.add(item);
		return new Order(this.cart, address);
	}

	public Order addAddress(String address) {
		this.address = address;
		return new Order(this.cart, this.address);
	}

	@Override
	public String toString() {
		return "Order [cart=" + cart + ", address=" + address + "]";
	}

}
