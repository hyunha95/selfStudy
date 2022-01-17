package com.kh.test.break_continue;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
//		t.test1();
		t.test2();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 하나 입력하세요 : ");
		int inputNum = sc.nextInt();
		int sum = 1;
		for(int i = 1; i <= inputNum; i++) {
			if(i % 2 != 0) {
				sum *= i;
			}
		}
		System.out.println("1부터 입력한 정수까지의 홀수의 곱 : " + sum);
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 : ");
		int inputNum1 = sc.nextInt();
		System.out.print("정수 2 : ");
		int inputNum2 = sc.nextInt();
		int biggerNum;
		int smallerNum;
		
		if(inputNum1 < inputNum2) {
			smallerNum = inputNum1;
			biggerNum = inputNum2;
		}
		else {
			smallerNum = inputNum2;
			biggerNum = inputNum1;
		}
		
		int i = smallerNum;
		int sum = 0;
		while(i <= biggerNum) {
			if(i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", smallerNum, biggerNum, sum);
	}
}

/*
 *  - 패키지 : com.kh.test.break_continue
[문제 1]
- 클래스 : com.kh.test.break_continue.Test1.java
- 메소드명 : public void test1()
	1) 정수 한 개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요.
- 메소드명 : public void test2()
	2) 사용자로부터 정수를 두개 입력 받아서, 작은 정수에서 큰 정수까지 홀수의 합을 구하세요.
	 	Tip. 큰수/작은수에 해당하는 변수를 사용할 것.
     	결과:
     	정수를 하나 입력하세요. => 100
     	다른 정수를 하나 입력하세요. => 1
     	====================
     	1부터 100까지의 홀수의 합은 2500입니다.

 */
