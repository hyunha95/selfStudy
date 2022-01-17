package kh.java.nested.loop;

import java.util.Scanner;

public class NestedLoopStudy {

	public static void main(String[] args) {
		NestedLoopStudy study = new NestedLoopStudy();
		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
//		study.test6();
//		study.test7();
	}
	
	/**
	 * □□□
	 * □	 
	 * □□□
	 * □
	 * □□□
	 */
	public void test7() {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("□");	
				if(i % 2 != 0 ) {
					break;
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * ★
	 * ★★
	 * ★★★
	 * ★★★★
	 * ★★★★★
	 */
	public void test6() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("★");
				if(i==j)
					break;
			}
			System.out.println();
		}
		
		System.out.println();

			outer:
			for(int i = 0; ; i++) {
				for(int j = 0; j <= i; j++) {
					if(i==10) break outer;
					System.out.print("★");
				}
				System.out.println();
			}
	}
	
	/**
	 * 
	 */
	public void test5() {
		outer:
		for(int i = 2; i <=9; i++) {
			System.out.println("==== " + i + "단 ====");
			for(int j = 1; j <=9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
				if(i == j) {						
					System.out.println();
					continue outer; //바깥반복문의 시작(증감식)으로 이동
				}
			}
		}
	}
	
	/**
	 * 라벨이 있는 반복문
	 *  - break
	 *  - continue
	 */
	public void test4() {
		outer:
		for(int i = 2; i <=9; i++) {
			System.out.println("==== " + i + "단 ====");
			for(int j = 1; j <=9; j++) {
				//50미만까지만 출력
				if(i * j > 50) 
					break outer; // outer반복문 break;
				System.out.println(i + "*" + j + "=" + (i * j));
			}
			System.out.println();
		}
	}
	
	/**
	 * 구구단
	 * 2 * 1 = 2;
	 * 2 * 2 = 4;
	 * ...
	 * 2 * 9 = 18;
	 * 
	 * 3 * 1 = 3
	 * 3 * 2 = 6
	 * ...
	 * 3 * 9 = 27
	 * 
	 * 4 * 1 = 4
	 * 4 * 2 = 8
	 * ...
	 * 
	 * 9 * 1 = 9
	 * 9 * 2 = 18
	 * ...
	 * 9 * 9 = 81

	 */
	public void test3() {
		for(int i = 2; i <=9; i++) {
			System.out.println("==== " + i + "단 ====");
			for(int j = 1; j <=9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}
			System.out.println();
		}
	}
	
	/**
	 * 별찍기
	 * 
	 * ★★★★★
	 * ★★★★★
	 * ★★★★★
	 * 
	 * 사용자로부터 행/열의 수를 입력받고, 별찍기를 하세요.
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행 : ");
		int row = sc.nextInt();
		System.out.print("열 : ");
		int column = sc.nextInt();
		System.out.println("문자 : ");
		char ch = sc.next().charAt(0);
		
		for(int a = 0; a < row;a++) {
			for(int b = 0; b < column; b++ ) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
//		for(int i = 0; i < 3;i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print('★');
//			}
//			System.out.println();
//		}
	}
	
	/**
	 * 중첩반복문
	 * 
	 * - 행 열 표현하기
	 *	 1. 바깥반복문 : 행 row
	 *	 2. 안쪽반복문 : 열 column
	 */	
	public void test1() {
		
		for(int i = 0; i < 6; i++) {
			
			for(int j = 0; j < 8; j++) {
				System.out.print("(" + i + ", " + j + ")");
			}
			System.out.println();
		}
	}
}
