package com.kh.member.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Tb_Member extends Member{
	
	private Date delDate;
	private String delFlag;
	public Tb_Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_Member(String id, String name, String gender, Date birthday, String email, String address,
			Timestamp regDate, Date delDate, String delFlag) {
		super(id, name, gender, birthday, email, address, regDate);
		this.delDate = delDate;
		this.delFlag = delFlag;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	@Override
	public String toString() {
		return super.toString() + "\t" + delDate + "\t" + delFlag;
	}
	
	
	
	
	
	
}
