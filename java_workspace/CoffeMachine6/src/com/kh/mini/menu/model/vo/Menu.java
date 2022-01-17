package com.kh.mini.menu.model.vo;

public class Menu {
	private String name;
	private int price;
	private boolean ExtraShot;
	private boolean sizeUp;
	private boolean optionIce;
	
	public Menu() {}

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isExtraShot() {
		return ExtraShot;
	}

	public void setExtraShot(boolean extraShot) {
		ExtraShot = extraShot;
	}

	public boolean isSizeUp() {
		return sizeUp;
	}

	public void setSizeUp(boolean sizeUp) {
		this.sizeUp = sizeUp;
	}

	public boolean isOptionIce() {
		return optionIce;
	}

	public void setOptionIce(boolean optionIce) {
		this.optionIce = optionIce;
	}

	

}