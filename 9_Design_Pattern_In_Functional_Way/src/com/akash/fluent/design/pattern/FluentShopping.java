package com.akash.fluent.design.pattern;

public class FluentShopping {
	
	public static void main(String[] args) {
		Order.place(order->
			order.addAddress("EC")
			.addItem("Headphone")
			.addItem("Mobile")
				);
	}

}
