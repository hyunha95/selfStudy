package kh.java.inherit.product;

import java.util.Date;

/**
 * brand
 * productCode
 * productName
 * price
 * makeDate
 * 
 * resolution 화질
 * size
 * 
 */
public class Tv extends Product{
	
	private String resolution; //FHD, UHD, 8k
	private int size;
	public Tv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tv(String brand, String productCode, String productName, int price, Date makeDate, String resolution,
			int size) {
		super(brand, productCode, productName, price, makeDate);
		this.resolution = resolution;
		this.size = size;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String productInfo() {
		return super.productInfo() + ", " + resolution + ", " + size; 
	}
}
