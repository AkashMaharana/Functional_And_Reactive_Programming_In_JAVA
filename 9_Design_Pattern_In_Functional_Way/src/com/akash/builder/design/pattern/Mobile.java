package com.akash.builder.design.pattern;

public class Mobile {

	private int ram;
	private int storage;
	private int battery;
	private int camera;
	private String processor;
	private double screenSize;

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public Mobile(MobileBuilder mobileBuilder) {
		this.ram = mobileBuilder.getRam();
		this.storage = mobileBuilder.getBattery();
		this.battery = mobileBuilder.getRam();
		this.camera = mobileBuilder.getCamera();
		this.processor = mobileBuilder.getProcessor();
		this.screenSize = mobileBuilder.getScreenSize();
	}

	@Override
	public String toString() {
		return "Mobile [ram=" + ram + ", storage=" + storage + ", battery=" + battery + ", camera=" + camera
				+ ", processor=" + processor + ", screenSize=" + screenSize + "]";
	}

}
