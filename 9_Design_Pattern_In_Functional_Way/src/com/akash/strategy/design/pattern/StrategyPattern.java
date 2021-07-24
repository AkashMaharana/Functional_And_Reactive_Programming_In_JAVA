package com.akash.strategy.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {

	public static void main(String[] args) {
		List<Stock> stockList=new ArrayList<>();
		stockList.add(new Stock("Amazon",456.90,10));
		stockList.add(new Stock("Google",109.90,10));
		stockList.add(new Stock("Tesla",986.63,10));
		stockList.add(new Stock("Netflix",64.90,10));
		stockList.add(new Stock("Facebook",4006.90,10));
		StockFilter filter=new StockFilter();
		filter.filterStock(stockList, stock->stock.getPrice()>300.0).forEach(System.out::println);
	}
}
