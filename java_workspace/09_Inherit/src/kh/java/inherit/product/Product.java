package kh.java.inherit.product;

import java.util.Date;

/**
 * 자식 상품클래스가 가지고 있어야 할 공통 필드/메소드를 작성
 * 자식 상품클래스의 보편적 특징 - 자식클래스를 추상화해서 부모클래스를 작성한다.
 * 
 *
 *
 */
public class Product {

	private String brand;
	private String productCode;
	private String productName;
	private int price;
	private Date makeDate;
	public Product() {
		super();
	}
	
	public Product(String brand, String productCode, String productName, int price, Date makeDate) {
		super();
		this.brand = brand;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.makeDate = makeDate;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	
	public String productInfo() {
		return brand + ", " + productCode + ", " + productName + ", " + price + ", " + makeDate;
	}
	
}
