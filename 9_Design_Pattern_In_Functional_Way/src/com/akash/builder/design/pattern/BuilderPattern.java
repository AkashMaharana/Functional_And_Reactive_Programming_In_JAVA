package com.akash.builder.design.pattern;

public class BuilderPattern {

	public static void main(String[] args) {
		MobileBuilder mobileBuilder = new MobileBuilder();
		Mobile myMobile = mobileBuilder.with(myBuilder -> {
			myBuilder.setRam(10);
			myBuilder.setBattery(1);
			myBuilder.setProcessor("QualCom");
		}).createMobile();

		System.out.println(myMobile);
	}

}
