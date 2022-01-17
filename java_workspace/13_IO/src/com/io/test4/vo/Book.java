package com.io.test4.vo;

import java.io.Serializable;
import java.util.Calendar;

public class Book implements Serializable{

	private String title;
	private String author;
	private int price;
	private Calendar dates;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, int price, Calendar dates) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.dates = dates;
	}
	
	@Override
	public String toString() {
		int yyyy = dates.get(Calendar.YEAR);
		int MM = dates.get(Calendar.MONTH) + 1;
		int dd = dates.get(Calendar.DAY_OF_MONTH);
		return "(" + yyyy + "년 " + MM + "월 " + dd + "일 출간)";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}
	
	
}
