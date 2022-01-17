package test.controller;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Test5 t = new Test5();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 1~9 사이의 정수를 입력하세요 : ");
		int inputNum1 = sc.nextInt();
		System.out.println("2. 1~9 사이의 정수를 입력하세요 : ");
		int inputNum2 = sc.nextInt();
		
		if((inputNum1 > 0 && inputNum1 < 11) && (inputNum2 > 0 && inputNum2 < 11)) {
			int result = inputNum1 * inputNum2;
			String str = Integer.toString(result);
			//System.out.println(result);
			
			char ch0 = ' ';
			char ch1 = ' ';
			boolean flag = true; //한 자리라고 가정
			
			if(result < 10) {
				ch0 = str.charAt(0);			
			}
			else {
				ch0 = str.charAt(0);			
				ch1 = str.charAt(1);	
				flag = false;
			}
//		System.out.println(ch0);
//		System.out.println(ch1);
			
			System.out.println(flag == true ? "한 자리 수 입니다." : "두자리 수 입니다.");
		}
		else {
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
		}
		
	}
}
