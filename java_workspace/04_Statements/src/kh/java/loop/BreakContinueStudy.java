package kh.java.loop;

import java.util.Scanner;

public class BreakContinueStudy {

	public static void main(String[] args) {
		BreakContinueStudy study = new BreakContinueStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
	}
	
	/**
	 * while문에서 continue 사용할때는 continue 하위에 증감식이 있어서는 안된다.
	 */
	public void test4() {
		int i = 0;
		while(i++ <= 100) {
			
			if(i%2 != 0)
				continue;
			
			System.out.print(i + " ");
		}
	}
	
	/**
	 * continue
	 * 	이하코드는 실행하지 않고, 즉시 반복문의 시작지점(조건식)으로 이동한다.
	 * 	단, for문인 경우는 증감식으로 이동한다.
	 */
	public void test3() {
		for(int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		
		System.out.println();
		int dan = 3;
		for(int n = 1; n < 10; n++) {
			
			if((dan * n) % 6 != 0) {
				continue;
			}
			System.out.printf("%d * %d = %d%n", dan, n, dan * n);
		}
	}
	
	/**
	 * 1부터 사용자입력값까지의 합을 구하세요.
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int inputNum = sc.nextInt();
		int sum = 0;
		int i = 1;
		while(true) {
			sum += i;
			i++;
			if(i > inputNum) {
				break;
			}
		}
		System.out.print(sum);
	}
	
	/**
	 * break
	 * 즉시 반복문을 탈출하는 명령어
	 */
	public void test1() {
		int sum = 0;
		int i = 1;	
		while(true) {
			sum += i; // sum = sum + i;
			i++;
			if(i > 10) {
				break;
			}
		}
		System.out.println(sum);
	}
}
