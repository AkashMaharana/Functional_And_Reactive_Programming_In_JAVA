package com.akash.maharana;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PayingWithMap {

	public static void main(String[] args) {
		Map<String, String> input = new HashMap<>();
		input.put("56789", "Akash");
		input.put("67586", "Rakesh");
		input.put("453245", "Vikrant");
		input.put("7645", "Mamtha");
		input.put("3434", "Shimly");
		input.put("4564353", "Harshita");
		input.put("5434", "Pallugula");

		input.forEach((key, value) -> System.out.println(key + " : " + value));
		System.out.println();

		Map<String, String> filteredContacts = input.entrySet().stream().filter(contact -> contact.getKey().length() == 4)
				.collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
		filteredContacts.forEach((key,value)->System.out.println(key+" : "+value));
		System.out.println();
		
		LinkedHashMap<String, String> sortedMap = input.entrySet().stream().sorted(Entry.comparingByValue())
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1,v2)->v1, LinkedHashMap::new));
		
		sortedMap.forEach((key,value)->System.out.println(key+" : "+value));
		System.out.println();
		
		OptionalDouble average=input.keySet().stream().mapToDouble(number->Double.valueOf(number)).average();
		System.out.println(average.getAsDouble());
	}

}
