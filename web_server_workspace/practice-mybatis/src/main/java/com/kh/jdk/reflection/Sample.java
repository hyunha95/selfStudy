package com.kh.jdk.reflection;

public class Sample {

	private int n;
	private String str;
	
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sample(int n, String str) {
		super();
		this.n = n;
		this.str = str;
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return "Sample [n=" + n + ", str=" + str + "]";
	}
	
	
	
}
