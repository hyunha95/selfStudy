package com.kh.mini.member.model.vo;

public class Member {
	private String name;
	private String number;
	private int point;
	private String password;
	
	public Member() {
		super();
	}
	public Member(String name, String number, int point, String password) {
		super();
		this.name = name;
		this.number = number;
		this.point = point;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", number=" + number + ", point=" + point + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31; 
		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + point;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (number == null) {
//			if (other.number != null)
//				return false;
//		} else if (!number.equals(other.number))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (point != other.point)
//			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
}
