package com.oop.coffee.model.dto;

public class Coffee {

	private String origin;
	private String location;
	
	public Coffee() {
		
	}
	public Coffee(String origin, String location) {
		this.origin = origin;
		this.location = location;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigin() {
		return origin;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	
	public String printInfo() {
		return origin + "\t\t" + location;
	}
}
