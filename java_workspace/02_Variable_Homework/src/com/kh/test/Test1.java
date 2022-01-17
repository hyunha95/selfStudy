package com.kh.test;
/*
각 자료형별 변수를 만들고 초기화한 후 그 값을 출력하는 코드를 작성해 보자.

	- 정수형 100, 9999억, 
	- 실수 486.520(float), 567.890123
	- 문자 A
	- 문자열 Hello world, 
	- 논리 true
 
    단, 변수를 이용하여 출력하시오 .

*/
public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test();
		
	}

	public void test() {
		int num1 = 100;
		long num2 = 999_900_000_000L;
		
		float f = 234.567f;
		double d = 567.12345;
		
		char c = 'A';
		String str = "Hello world";
		
		boolean b = true;
		
		System.out.println("num1="+num1); 
		System.out.println("num2="+num2);
		
		System.out.println("f="+f); 
		System.out.println("d="+d); 
		
		System.out.println("c="+c); 
		System.out.println("str="+str); 
		
		System.out.println("b="+b); 
	}

}
