package com.akash.builder.design.pattern;

import java.util.function.Consumer;

public class MobileBuilder {

	private int ram;
	private int storage;
	private int battery;
	private int camera;
	private String processor;
	private double screenSize;

	public int getRam() {
		return ram;
	}

	public int getStorage() {
		return storage;
	}

	public int getBattery() {
		return battery;
	}

	public int getCamera() {
		return camera;
	}

	public String getProcessor() {
		return processor;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
		buildFields.accept(this);
		return this;
	}

	public Mobile createMobile() {
		return new Mobile(this);
	}

}
