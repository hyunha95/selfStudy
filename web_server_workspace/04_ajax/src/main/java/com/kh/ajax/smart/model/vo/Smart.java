package com.kh.ajax.smart.model.vo;

import java.sql.Date;

public class Smart {

	private String pname;
	private int amount;
	private Date pdate;
	private int accAmount;
	private int rank;
	
	public Smart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Smart(String pname, int amount, Date pdate, int accAmount, int rank) {
		super();
		this.pname = pname;
		this.amount = amount;
		this.pdate = pdate;
		this.accAmount = accAmount;
		this.rank = rank;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public int getAccAmount() {
		return accAmount;
	}

	public void setAccAmount(int accAmount) {
		this.accAmount = accAmount;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Smart [pname=" + pname + ", amount=" + amount + ", pdate=" + pdate + ", accAmount=" + accAmount
				+ ", rank=" + rank + "]";
	}

	

	
	
}
