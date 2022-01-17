/* 실습문제
 * 
 * 실행용 클래스
* 패키지 : emp.run
* 클래스명 : TestEmp
* 실행메소드 : public static void main(String[] args)
* 내용 : Employee의 printEmployee메소드실행
기능제공 클래스
* 패키지 : emp.model.vo
* 클래스명 : Employee
* 추가 메소드 : public void printEmployee(){   }
* 내용 : 자기소개출력 (본인 이름, 나이, 생년월일)
 */
package com.kh.test;

public class Test1 {
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.primitiveType1();
		test1.primitiveType2();
		test1.primitiveType3();
		test1.primitiveType4();
		test1.primitiveType5();		
	}
	
	public void primitiveType1() {
		//정수형
		byte bnum = 100;
		long lnum = 999_900_000_000L;
		System.out.println("정수형");
		System.out.println(bnum);
		System.out.println(lnum);
		System.out.println("");
	}
	
	public void primitiveType2() {
		//실수형
		float fnum = 486.567F;
		double dnum = 567.890123;
		System.out.println("실수형");
		System.out.println(fnum + "(float)");
		System.out.println(dnum);
		System.out.println("");
	}
	
	public void primitiveType3() {
		//문자
		char A = 'A';
		System.out.println("문자");
		System.out.println(A);
		System.out.println("");
	}
	
	public void primitiveType4() {
		//문자열
		String strHelloWorld = "Hello World";
		System.out.println("문자열");
		System.out.println(strHelloWorld);
		System.out.println("");
	}
	
	public void primitiveType5() {
		//논리형
		boolean bool = true;
		System.out.println("논리형");
		System.out.println(bool);
		System.out.println("");
	}
	
}
