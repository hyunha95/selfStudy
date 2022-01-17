package com.kh.mini.stock.model.vo;

public class Stock {
	private int beans;
	private int decafBeans;
	private int ice;
	private int water;
	private int syrup;
	private int choco;
	private int smallCup;
	private int largeCup; 
	private int straw;
	private int milk;
	private int vanillaSyrup;
	
	@Override
	public String toString() {
		return "Stock [beans=" + beans + ", decafBeans=" + decafBeans + ", ice=" + ice + ", water=" + water + ", syrup="
				+ syrup + ", choco=" + choco + ", smallCup=" + smallCup + ", largeCup=" + largeCup + ", straw=" + straw
				+ ", milk=" + milk + ", vanillaSyrup=" + vanillaSyrup + "]";
	}
	public Stock(int beans, int decafBeans, int ice, int water, int syrup, int choco, int smallCup, int largeCup,
			int straw, int milk, int vanillaSyrup) {
		super();
		this.beans = beans;
		this.decafBeans = decafBeans;
		this.ice = ice;
		this.water = water;
		this.syrup = syrup;
		this.choco = choco;
		this.smallCup = smallCup;
		this.largeCup = largeCup;
		this.straw = straw;
		this.milk = milk;
		this.vanillaSyrup = vanillaSyrup;
	}
	public Stock() {
		super();
	}
	public int getBeans() {
		return beans;
	}
	public void setBeans(int beans) {
		this.beans = beans;
	}
	public int getDecafBeans() {
		return decafBeans;
	}
	public void setDecafBeans(int decafBeans) {
		this.decafBeans = decafBeans;
	}
	public int getIce() {
		return ice;
	}
	public void setIce(int ice) {
		this.ice = ice;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getSyrup() {
		return syrup;
	}
	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}
	public int getChoco() {
		return choco;
	}
	public void setChoco(int choco) {
		this.choco = choco;
	}
	public int getSmallCup() {
		return smallCup;
	}
	public void setSmallCup(int smallCup) {
		this.smallCup = smallCup;
	}
	public int getLargeCup() {
		return largeCup;
	}
	public void setLargeCup(int largeCup) {
		this.largeCup = largeCup;
	}
	public int getStraw() {
		return straw;
	}
	public void setStraw(int straw) {
		this.straw = straw;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getVanillaSyrup() {
		return vanillaSyrup;
	}
	public void setVanillaSyrup(int vanillaSyrup) {
		this.vanillaSyrup = vanillaSyrup;
	}
	
}
