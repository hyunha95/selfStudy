package kh.java.inherit.product;

import java.util.Date;

/**
 * 
 * brand
 * productCode
 * productName
 * price
 * makeDate
 * 
 * os
 * 
 * phoneNumber
 * carrier
 * 
 *
 */
public class SmartPhone extends Product{

	private String os;
	private String phoneNumber;
	private String carrier;
	
	public SmartPhone() {
		super();
	}
	
	public SmartPhone(
			String brand, String productCode, String productName, int price, Date makeDate,
			String os, String phoneNumber, String carrier
	) {
		super(brand, productName, productCode, price, makeDate);
		this.os = os;
		this.phoneNumber = phoneNumber;
		this.carrier = carrier;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	@Override
	public String productInfo() {
		return super.productInfo() + ", " + os + ", " + phoneNumber + ", " + carrier;
	}
}
