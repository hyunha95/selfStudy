package com.collection.set.cart;

import java.util.Comparator;
import java.util.Objects;

public class Cart {

	private String name;
	private int count;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return name + " - " + count + "개\n";
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other)
			return true;
		
		if(!(other instanceof Cart)) {
			return false;
		}
		
		Cart otherCart = (Cart) other;
		
		if(!this.name.equals(otherCart.name))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,count);
	}
	
	static class CartNameAsc implements Comparator<Cart>{
		@Override
		public int compare(Cart c1, Cart c2) {
			return c1.getName().compareTo(c2.getName());
		}
		
	}

	
}


















