package test.controller;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1~100 사이의 정수를 입력하세요 : ");
			int inputNum = sc.nextInt();
			if(inputNum > 100 || inputNum < 1) {
				System.out.println("다시 입력하세요 : ");
				continue;
			}
			else {
				if(inputNum % 2 == 0) {
					System.out.println("2의 배수입니다.");
					break;
				}
				else {
					System.out.println("는 2의 배수가 아닙니다.");
					break;
				}
			}
		} while(true);
		
		System.out.println("종료!");
	}
}
