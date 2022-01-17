package com.oop.device;

public abstract class Device {

	private String brand;
	private String name;
	private int price;
	
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Device(String brand, String name, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	public abstract String getAd();
	
	@Override
	public String toString() {
		return "brand=" + brand + ", name=" + name + ", price=" + price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
