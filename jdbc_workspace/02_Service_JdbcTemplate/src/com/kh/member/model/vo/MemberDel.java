package com.kh.member.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberDel extends Member {

	private Timestamp delDate;

	public MemberDel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDel(String id, String name, String gender, Date birthday, String email, String address,
			Timestamp regDate, Timestamp delDate) {
		super(id, name, gender, birthday, email, address, regDate);
		this.delDate = delDate;
	}

	public Timestamp getDelDate() {
		return delDate;
	}

	public void setDelDate(Timestamp delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" +  delDate;
	}
}