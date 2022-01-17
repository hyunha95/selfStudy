package com.kh.web.member.model.vo;

import java.sql.Date;

public class Member {

	private String userId;
	private String pwd;
	private String userName;
	private String ssn;
	private String email;
	private String tel;
	private String job;
	private String hobby;	// "독서,개발,운동"
	private Date regDate;	// 가입일
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String userId, String pwd, String userName, String ssn, String email, String tel, String job,
			String hobby, Date regDate) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.userName = userName;
		this.ssn = ssn;
		this.email = email;
		this.tel = tel;
		this.job = job;
		this.hobby = hobby;
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", pwd=" + pwd + ", userName=" + userName + ", ssn=" + ssn + ", email="
				+ email + ", tel=" + tel + ", job=" + job + ", hobby=" + hobby + ", regDate=" + regDate + "]";
	}

}
