package com.akash.maharana;

public class TransformingOperators {
	
	//Transforming the emissions to the same type or different
	
	//map(function) : transform the emissions to the type defined
	
	//cast(ClassName.clas) : take class name as argument and convert the emissions to that type
	
	//delay(TimeUnit) : delay the emissions for the specified amount of time
	
	//delaySubscripton(TimeUnit) : delay the subscription for the specified amount of time
	
	//scan(Accumulator) : takes an accumulator function and apply to the first item and feeds result to next
		// scan((x,y)->x+y)
	
	//sorted() : sort the upstream emissions
	
	//repeat(int) : repeat the subscription for the specified number of times after on complete

}
