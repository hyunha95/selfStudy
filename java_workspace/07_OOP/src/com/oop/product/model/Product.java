package com.oop.product.model;

public class Product {

	private String productID;
	private String productName;
	private String productArea;
	private int price;
	private double tax;
	
	public Product() {
		
	}
	public Product(
			String productID, String productName, String productArea, 
			int price, double tax) {
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tax = tax;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductArea() {
		return productArea;
	}
	public int getPrice() {
		return price;
	}
	public double getTax() {
		return tax;
	}
	
	public void information() {
		System.out.println(productID + "\t" + productName + "\t" + productArea + "\t" + price + "\t" + tax);
	}
}
