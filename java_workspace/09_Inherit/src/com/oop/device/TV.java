package com.oop.device;

public class TV extends Device{

	private int channel;

	public TV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TV(String brand, String name, int price, int channel) {
		super(brand, name, price);
		this.channel = channel;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", channel=" + channel;
	}
	
	@Override
	public String getAd() {
		return "화면뒤의 진짜세계를 경험하세요. "+ getBrand()+" - "+ getName();
	}
	
	public void channelUp() {
		System.out.println("채널을 올린다.");
	}
	
	public void channelDown() {
		System.out.println("채널을 내린다.");
	}
	

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
	
	
}
