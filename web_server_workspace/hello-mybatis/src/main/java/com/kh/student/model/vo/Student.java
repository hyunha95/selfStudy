package com.kh.student.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int no;
	private String name;
	private String tel;
	private Date regDate; // mybatis가 내부적으로 timestamp타입으로 변환 관리. 시분초정보 db전달 가능.
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int no, String name, String tel, Date regDate) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", tel=" + tel + ", regDate=" + regDate + "]";
	}
	
	
}
