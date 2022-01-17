package com.kh.var;

import java.util.Scanner;

public class Example {

	public void example1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		int result1 = num1 + num2;
		System.out.println("더하기 결과 : " + result1);
		int result2 = num1 - num2;
		System.out.println("빼기 결과 : " + result2);
		int result3 = num1 * num2;
		System.out.println("곱하기 결과 : " + result3);
		int result4 = num1 / num2;
		System.out.println("나누기한 몫 : " + result4);
		int result5 = num1 % num2;
		System.out.println("나누기한 나머지 : " + result5);
	}
	
	public void example2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
		double width = sc.nextDouble();
		System.out.print("세로 : ");
		double length = sc.nextDouble();
		
		double area = width * length;
		System.out.println("면적 : " + area);
		double perimeter = (width + length) * 2;
		System.out.println("둘레 : " + perimeter);
	}
	
	public void example3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열(3글자이상)을 입력하시오 : ");
		String str = sc.next();
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		System.out.println("첫 번째 문자 : " + ch1);
		System.out.println("두 번째 문자 : " + ch2);
		System.out.println("세 번째 문자 : " + ch3);
		
	}
}



















