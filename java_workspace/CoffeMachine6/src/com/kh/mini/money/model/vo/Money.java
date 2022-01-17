package com.kh.mini.money.model.vo;

public class Money {
    private int money;

	public Money() {
		super();
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Money [money=" + money + "원]";
	}

}
