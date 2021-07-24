package com.akash.command.design.pattern;

public class CommandPattern {
	
	public static void main(String[] args) {
		AirConditioner airConditioner1=new AirConditioner();
		AirConditioner airConditioner2=new AirConditioner();
		
		AirConditionRemote remote1=new AirConditionRemote();
		remote1.setCommand(airConditioner1::turnOn);
		remote1.buttonPressed();
		
		AirConditionRemote remote2=new AirConditionRemote();
		remote2.setCommand(airConditioner2::turnOff);
		remote2.buttonPressed();
	}

}
