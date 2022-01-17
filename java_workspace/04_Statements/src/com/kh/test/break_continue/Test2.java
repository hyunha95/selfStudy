package com.kh.test.break_continue;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test1();
	}
	
	public void test1() {
		int randomNum = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; true ; i++) {
			System.out.print("정수를 하나 입력하세요 : ");
			int inputNum = sc.nextInt();
			if(randomNum < inputNum) {
				System.out.println("입력하신 정수보다 작습니다.");
			}
			else if(randomNum == inputNum) {
				System.out.println("정답입니다." + i + "회만에 정답을 맞추셨습니다.");
				break;
			}
			else {
				System.out.println("입력하신 정수보다 큽니다.");
			}
		}
	}
}

/*
 * [문제 2]
- 클래스 : com.kh.test.break_continue.Test2.java
- 메소드명 : public void test()
	1~100 사이의 임의의 난수를 발생시키고, 
	   정수 한 개를 입력 받아, 
	   난수가 입력 받은 정수보다 작으면 "입력하신 정수보다 작습니다." 출력, 
	   난수가 입력 받은 정수보다 크면 "입력하신 정수보다 큽니다." 출력하세요.
	   단, 정답을 맞출 때까지 정수를 계속 입력 받아 프로그램이 반복되도록 하고, 
	   정답인 경우 "정답입니다. 5회 만에 정답을 맞추셨습니다."와 같이 
	   몇 회 만에 정답을 맞추었는지 출력하도록 작성하세요.
 */
