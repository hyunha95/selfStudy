package com.oop.device;

public class Laptop extends Device{

	private int capacity;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(String brand, String name, int price, int capacity) {
		super(brand, name, price);
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", capacity=" + capacity;
	}
	
	@Override
	public String getAd() {
		return "비대면 시대의 유일한 경쟁력. "+ getBrand() +" - "+ getName();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
