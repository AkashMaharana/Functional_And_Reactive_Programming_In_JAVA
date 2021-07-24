package com.akash.strategy.design.pattern;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StockFilter {
	
	public List<Stock> filterStock(List<Stock> stockList,Predicate<Stock> condition){
		return stockList.stream().filter(condition::test).collect(Collectors.toList());
	}

}
