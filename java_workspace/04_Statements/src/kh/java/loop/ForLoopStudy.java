package kh.java.loop;

import java.util.Scanner;

public class ForLoopStudy {

	public static void main(String[] args) {
		ForLoopStudy study = new ForLoopStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	/**
	 * 반복횟수
	 * 1. compile-time
	 * 2. run-time
	 * 		-> 사용자가 직접 반복여부를 결정하게 할 수 있다.
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		String menu = "------ 메뉴 ------\n"
				+ "1. 닭고기\n"
				+ "2. 소고기\n"
				+ "3. 양고기\n"
				+ "---------------------\n"
				+ "선택 : ";
		
		for(;;) {
			System.out.print(menu);
			int num = sc.nextInt();
			System.out.println(num + "번을 선택하셨습니다.");
			
			System.out.println("더 주문하시겠습니까?(yes/no) : ");
			String yn = sc.next();
			// 문자열의 값비교는 ==이 아니라 equals메소드를 이용한다.
			// 리터럴을 앞에 쓰는 것이 보다 안전하다.
//			if(yn.equals("no")) 
			if("no".equals(yn)) {
				break; // 반복문 불럭을 즉시 탈출
			}
		}
		System.out.println("종료!!!");
	}
	
	
	
	/**
	 * 사용자가 지정한 두수사이의 정수를 모두 출력하세요.
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 : ");
		final int a = sc.nextInt();
		System.out.print("정수 2 : ");
		final int b = sc.nextInt();
		
		// 큰수 / 작은수 판별
		int max = a > b ? a : b;
		int min = a < b ? a : b;
		
			for(int i = min; i <= max ; i++) {
				System.out.println(i);
			}
	}
	
//	public void test4() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 1 : ");
//		final int a = sc.nextInt();
//		System.out.print("정수 2 : ");
//		final int b = sc.nextInt();
//		if(a < b) {			
//			for(int i = a; i <= b; i++ ) {
//				System.out.println(i);
//			}
//		}
//		else {
//			for(int i = b; i <= a; i++ ) {
//				System.out.println(i);
//			}
//		}
//	}
	
	/**
	 * 누적합구하기 : 1 ~ 100 정수의 합
	 */
	public void test3() {
		
		// 블럭 밖에 누적합을 위한 변수 선언
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
			sum += i;
			System.out.println(i);
		}
		
		System.out.println("누적합은 " + sum + "입니다.");
	}
	
	/**
	 * 사용자가 원하는 단수를 출력해주세요.
	 * (2 ~ 9 정수 입력 받기)
	 * 
	 * 5 * 1 = 5
	 * 5 * 2 = 10
	 * 5 * 3 = 15
	 * ....
	 * 5 * 8 = 40
	 * 5 * 9 = 45
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("단수를 입력하세요(2 ~ 9) : ");
				
		int dan = sc.nextInt();
		
		if(dan < 2 || dan > 9) {
			System.out.println("올바른 단수가 아닙니다.");
			return; //조기리턴
		}
			
		for(int n = 1; n < 10; n++) {
			System.out.printf("%d * %d = %d%n",dan, n, dan * n);
		}

		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수를 입력하세요 : ");
//		int num = sc.nextInt();
//		for(int i = 1; i <= 10; i++) {
//			System.out.printf("%d * %d = %d%n", num, i, i * num);
//		}
	}
	
	/**
	 * for(초기식; 조건식; 증감식){
	 * 		// 반복처리구문
	 * }
	 * 
	 * 초기식 : 반복문 실행시 최초 1회만 실행. 증감변수 초기화
	 * 조건식 : true/false 조건식이 true이면 for블럭실행, false면 반복문 중지
	 * 증감식 : 증감변수 증감처리
	 * 
	 * 초기식 - 조건식(true) - 반복구문 - 증감식
	 * 		 - 조건식(true) - 반복구문 - 증감식
	 * 		 - 조건식(true) - 반복구문 - 증감식
	 * 		 ...
	 * 		 - 조건식(false) - 반복구문 - 증감식
	 * 
	 * 1. 증감변수는 어떻게 변화하는가? 1 2 3 4 5 6 7 8 9 10 11(x)
	 * 2. 이 반복문은 몇번 실행되는가? 10
	 */
	public void test1() {
//		for(int i = 0; i < 10; i += 2) {
//			System.out.println("hello world" + i);
//		}
		
		//출력 : 1 3 5 7 9 11 13 15 17 19
		for(int i = 1; i < 20; i += 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//출력 : 10 9 8 7 6 5 4 3 2 1
		for(int m = 10; m > 0; --m) {
			System.out.print(m + " ");
		}
		
		System.out.println();
		
		//출력 : 3 6 9 12 ...... 999
		for(int k = 3; k < 1000; k += 3) {
			System.out.print(k + " ");
		}
	}
}










