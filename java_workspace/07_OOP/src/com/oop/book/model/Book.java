package com.oop.book.model;


/**
 * 1. 캡슐화 - private필드의 직접접근 제한, public 메소드를 통해 우회 사용
 * 2. getter/setter
 * 		- get/set으로 시작하고 대문자로 시작하는 필드명
 * 		- getter의 리턴타입은 필드의 타입과 동일. 매개변수부 없음.
 * 		- setter의 매개변수타입은 필드의 타입과 동일. 리턴타입이 void.
 * 		- 매개변수명과 필드명을 구분하기 위해 this를 사용한다.
 * 3. 기본생성자 / 모든 필드를 포함한 파라미터생성자
 *
 */
public class Book {

	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	//기본생성자
	public Book() {
		
	}
	//파라미터 생성자
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String author() {
		return author;
	}
	
	public void bookInformation() {
		System.out.println(title+ "\t" + price + "\t" + discountRate + " " + author);
	}
	
	
}
