package com.oop.employee.model.vo;

public class Employee {

	private int empNo;
	private String name;
	private char gender;
	private String phone;
	private String dept;
	private int salary;
	private double bonusPct;
	
	public Employee() {
		
	}
	public Employee(int empNo, String name, char gender, String phone) {
		this.empNo = empNo;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}
	public Employee(int empNo, String name, char gender, String phone, 
							String dept, int salary, double bonusPct) {
		this(empNo, name, gender, phone);
		this.dept = dept;
		this.salary = salary;
		this.bonusPct = bonusPct;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	public void bonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}
	public double bonusPct() {
		return bonusPct;
	}
	
	public void printEmployee() {
		System.out.println(
				empNo + ", " + name + ", " + gender + ", " + 
				phone + ", " + dept  + ", " + salary + ", " + bonusPct
			);
	}
}






