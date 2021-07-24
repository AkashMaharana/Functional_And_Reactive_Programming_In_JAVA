package com.akash.strategy.design.pattern;

public class Stock {

	private String stockName;
	private Double price;
	private Integer units;

	public Stock(String stockName, Double price, Integer units) {
		this.stockName = stockName;
		this.price = price;
		this.units = units;
	}

	public String getStockName() {
		return stockName;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getUnits() {
		return units;
	}

	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", price=" + price + ", units=" + units + "]";
	}

}
