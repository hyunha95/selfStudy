package com.kh.ajax.celeb.model.vo;

public class Celeb {

	private String name;
	private String phone;
	private int age;
	private String profile;
	private boolean married;

	public Celeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Celeb(String name, String phone, int age, String profile, boolean married) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.profile = profile;
		this.married = married;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return name + "," + phone + "," + age + ","  + profile + "," + married;
	}
	

}
