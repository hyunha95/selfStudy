/*
<객체실습>
클래스명 : com.oop.emp.model.Employee
	- 사원정보 관리용 클래스
	- Field 작성 : 캡슐화 반드시 적용함
	사번 : - empNo:int
	이름 : - empName:String
	소속부서 : - dept:String
	직급 : - job:String
	나이 : - age:int
	성별 : - gender:char
	급여 : - salary:int
	보너스포인트 : - bonusPoint:double
	핸드폰 : - phone:String
	주소 : - address:String
Employee 클래스의 메소드 작성
1. 키보드입력용 메소드 : empInput()
2. emp객체 모든 필드 출력용 메소드 : empOutput()
3. getter/setter메소드
* 실행용 클래스 : com.oop.emp.run.EmpTest
메뉴작성 : 메소드 작성
=>메뉴 화면의 예
public void mainMenu(){}
******* 사원 정보 관리 프로그램 ************
	1. 새 사원 정보 입력  => empInput() 메소드 실행
	2. 사원 정보 삭제 => 사원객체 참조변수에 null대입할  것.
	3. 사원정보 출력 =>  empOutput() 메소드 실행
	9. 끝내기
********************************************
 */

package com.oop.emp.model;

import java.util.Scanner;

public class Employee {

	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	// this 현재 메소드를 호출한 객체
	
	// 키보드 입력용 메소드
	public void empInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 번호 입력 : ");
		setEmpNo(sc.nextInt());
		
		System.out.print("사원 이름 입력 : ");
		setEmpName(sc.next());
		
		System.out.print("부서를 입력하세요 : ");
		setDept(sc.next());
		
		System.out.print("직급을 입력하세요 : ");
		setJob(sc.next());
		
		System.out.print("나이를 입력하세요");
		setAge(sc.nextInt());
		
		System.out.print("성별을 입력하세요 : ");
		setGender(sc.next().charAt(0));
		
		System.out.print("급여를 입력하세요 : ");
		setSalary(sc.nextInt());
		
		System.out.print("보너스포인트를 입력하세요 : ");
		setBonusPoint(sc.nextDouble());
		
		System.out.print("핸드폰 번호를 입력하세요 : ");
		setPhone(sc.next());
	
		System.out.print("주소를 입력하세요 : ");
		setAddress(sc.next());
	}
	
	//출력용 메소드
	public void empOutput() {
		System.out.println("empNo : " + getEmpNo());
		System.out.println("empName : " + getEmpName());
		System.out.println("dept : " + getDept());
		System.out.println("job : " + getJob());
		System.out.println("age : " + getAge());
		System.out.println("gender : " + getGender());
		System.out.println("salary : " + getSalary());
		System.out.println("bonusPoint : " + getBonusPoint());
		System.out.println("phone : " + getPhone());
		System.out.println("address : " + getAddress());
	}
	
	
	
	//getter, setter
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	public String getJob() {
		return job;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}
