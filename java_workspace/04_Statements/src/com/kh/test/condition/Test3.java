package com.kh.test.condition;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 study = new Test3();
		study.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("2. 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자를 입력하세요 : ");
		char ch = sc.next().charAt(0);
		int result = 0;
		
		if(num1 < 0 || num2 < 0) {
			somethingWrong();
		}
		else if(ch == '+') {
			result = num1 + num2;
			System.out.printf("%d %c %d = %d", num1, ch, num2, result);
			if(ch != '+') {
				somethingWrong();
			}
		}
		else if(ch == '-') {
			result = num1 - num2;
			System.out.printf("%d %c %d = %d", num1, ch, num2, result);
			if(ch != '-') {
				somethingWrong();
			}
		}
		else if(ch == '*') {
			result = num1 * num2;
			System.out.printf("%d %c %d = %d", num1, ch, num2, result);
			if(ch != '*') {
				somethingWrong();
			}
		}
		else if(ch == '/') {
			result = num1 / num2;
			System.out.printf("%d %c %d = %d", num1, ch, num2, result);
			if(ch != '/') {
				somethingWrong();
			}
		}	
		else {
			somethingWrong();
		}
	}
	
	public void somethingWrong() {
		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
	}
}

/*
[문제 3]
- 클래스 : com.kh.test.condition.Test3.java
- 메소드명 : public void test()
	정수 두개를 입력 받고, 연산자(+,-,*,/)를 입력받은 다음 계산한 뒤  결과를 출력하는 계산기 프로그램을 만들어보세요.      
	출력 예) 입력 5, 6, +
		   5+6=11
	음수가 입력되거나 +,-,*,/ 이외의 문자가 입력되면 "잘못 입력 하셨습니다.  프로그램을 종료합니다." 라는 문구가 출력되게 하세요.
*/