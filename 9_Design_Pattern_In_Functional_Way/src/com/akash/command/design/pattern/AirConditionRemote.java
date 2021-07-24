package com.akash.command.design.pattern;

public class AirConditionRemote {
	
	private Command command;
	
	public void setCommand(Command command) {
		this.command=command;
	}
	
	public void buttonPressed() {
		command.execute();
	}

}
