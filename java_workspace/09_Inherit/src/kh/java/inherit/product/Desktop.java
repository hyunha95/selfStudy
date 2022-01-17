package kh.java.inherit.product;

import java.util.Date;

/**
 * brand
 * productCode
 * productName
 * price
 * makeDate
 *
 * os
 * 
 * monitor
 * keyboard
 * mouse
 * 
 * 상속 특징
 * 1. 부모의 멤버(필드/메소드)를 자식클래스에서 선언없이 사용가능
 * 2. 모든 클래스는 java.lang.Object의 후손
 * 		- hashCode, toString, equals등의 메소드를 사용할 수 있다.
 * 3. 부모클래스의 생성자, 초기화블럭은 상속되지 않는다.
 * 		- 부모생성자는 super()를 통해 호출가능하다.
 * 4. private멤버는 상속은 되지만 직접 사용은 불가능
 * 		- public메소드를 이용해 우회접근
 * 		- 부모생성자를 호출해 필드값 설정(set) 가능
 *
 */
public class Desktop extends Product{

	private String os;
	private String monitor;
	private String keyboard;
	private String mouse;
	
	/**
	 * 부모생성자는 상속되지 않는다.
	 */
	public Desktop() {
		
	}
	
	/**
	 * 파라미터 생성자
	 * 	 
	 * 부모로 부터 물려받은 private field 값성정하기
	 * 1. public setter
	 * 2. 부모생성자 super()
	 * 		- 생성자 맨 첫줄에 단 한번만 사용가능.
	 * 		- this()와 동시에 사용불가능
	 * 
	 */
	public Desktop(
			String brand, String productCode, String productName, int price, Date makeDate,
			String os, String monitor, String keyboard, String mouse
	) {
		//0. 상속받은 private 필드 직접 접근 불가능
//		this.brand = brand;
//		this.productCode = productCode;
//		this.productName = productName;
//		this.price = price;
//		this.makeDate = makeDate;
		
		//1. public메소드이용
//		this.setBrand(brand);
//		this.setProductCode(productCode);
//		this.setProductName(productName);
//		this.setPrice(price);
//		this.setMakeDate(makeDate);
		
		//2. 부모생성자 호출 : 부모클래스안에서 처리되도록 함.
		super(brand, productCode, productName, price, makeDate);
		
		this.os = os;
		this.monitor = monitor;
		this.keyboard = keyboard;
		this.mouse = mouse;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	
	@Override
	public String productInfo() {
//		return getBrand() + ", " + getProductCode() + ", " + getProductName() + ", "
//			 + getPrice() + ", " + getMakeDate() + ", "  
//			 + os + ", " + monitor + ", " + keyboard + ", " + mouse;
		return super.productInfo()+ ", " + os + ", " + monitor + ", " + keyboard + ", " + mouse;
	}
	
}





















