package com.kh.test.break_continue;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
//		Test3 t = new Test3();
//		t.test1();
		
//		new Test3().test1();
		new Test3().test2();
	}
	
	//선생님 풀이
	public void test2() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("2보다 큰 정수를 입력하세요.");
			int num = sc.nextInt();
			
			if(num <= 2) {
				System.out.println("2보다 큰 수를 입력하세여.");
				continue;
			}
			
			// flag변수 설정
			boolean flag = checkPrimeNumber(num);
			
			System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");
			
			System.out.println("검사끝!");
		}
	}
	
	public boolean checkPrimeNumber(int num) {
		boolean flag = true;
		
		if(num % 2 == 0) {
			flag = false;
		}
		else {
			//1과 자기자신 외에 약수가 있는 지 검사
			for(int i = 2, cnt = 1; i <= num / 2; i += 2, cnt++) {
				System.out.println(cnt);
				if(num % i == 0) {
					flag = false;
					System.out.println("소수가 아닙니다." + i + "로 나누어 떨어집니다.");
					break;
				}
			}
		}
		return flag;
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		int inputNum;
		for(int i = 0; true; i++) {
			System.out.print("2보다 큰 정수를 입력하세요.");
			inputNum = sc.nextInt();
			
			if(inputNum <= 2) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
				continue;
			}
			else {
				break;
			}
		}
		
		boolean flag = true;
			if(inputNum % 2 == 0) {
				flag = false;
			}
			else {
				for(int j = 2; j < inputNum/2; j++) {
					if(inputNum%j ==0) {
						flag = false;
						break;
					}
				}
			}
		
		if(flag) {
			System.out.println("소수 입니다.");
		}
		else {
			System.out.println("소수가 아닙니다.");
		}

	}
}

/*
 * 
 * [문제 3]
- 클래스 : com.kh.test.break_continue.Test3.java
- 메소드명 : public void test()
	 2보다 큰 정수를 입력 받고, 입력 받은 정수가 소수이면 "소수다", 소수가 아니면 "소수가 아니다." 출력하고 프로그램을 종료하는 코드를 작성하세요.
	 단, 입력 받은 정수가 2보다 작은 경우 "잘못 입력하셨습니다. 다시 입력하세요." 출력 후 다시 정수를 입력 받도록 하세요.
?
	** 소수란? : 어떠한 정수를 1부터 자기 자신까지로 나누었을 때, 나누어 떨어지는 수가 1과 자기 자신 뿐인 수를 소수라고 한다.
 */


