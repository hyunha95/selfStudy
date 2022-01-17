package kh.java.condition;

import java.util.Scanner;

public class IfStudy {

	public static void main(String[] args) {
		IfStudy study = new IfStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
		study.test6();
	}
	
	/**
	 * 사용자한테 입력받은 문자 하나를 타입에 따라 구분해 출력하세요.
	 * 문자 [1]은 숫자입니다.
	 * 문자 [c]는 알파벳입니다.
	 * 문자 [A]는 알파벳입니다.
	 * 문자 [*]는 특수/기타문자입니다.
	 */
	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 하나 입력 : ");
		char ch = sc.next().charAt(0);
		String type = "";
		
		//숫자
		if(ch >= '0' && ch <= '9') {
			type = "숫자";
		}
		// 영문자
		else if((ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z')) {
			type = "영문자";
		}
		//특수문자
		else {
			type = "특수/기타문자";
		}
		
		System.out.printf("문자 [%c]는 %s입니다.", ch, type);
	}
	
	/**
	 * 중첩된 if문
	 * 
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		String grade = "";
		
		// block scope 블럭 유효범위
		// 블럭안에 변수를 선언하면 블럭안에서만 이용 가능하다.
		// 블럭밖에 변수를 선언하면 블럭 안팎에서 모두 이용 가능하다.
		if(score >= 90) {
			grade = "A";
			if(score>= 95) {
				grade += "+"; // grade = grade + "+"
			}
		} 
		else if(score >= 80) {
			grade = "B";
			if(score >= 85) {
				grade += "+"; 	
			}
		} 
		else if(score >= 70) {
			grade = "C";
			if(score >= 75) {
				grade += "+";
			}
		} 
		else if(score >= 60) {
			grade = "D";
			// block안의 코드가 단 한줄인 경우만 생략가능
			if(score >= 65) {
				grade += "+";
			}
		}
		else {
			grade = "F";
		}
		System.out.printf("점수 : %d, 학점 : %s%n", score, grade);
	}
	
	/**
	 * 여러개의 if로 처리하기;
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 :");
		int score = sc.nextInt();
		char grade = ' ';
		
		// 90 ~ 100
		if(score >= 90 && score <= 100) {
			grade = 'A';
		} 
		
		// 80 ~89
		if(score < 90 && score >= 80) {
			grade = 'B';
		} 
		
		// 70 ~ 79
		if(score < 80 &&score >= 70) {
			grade = 'C';
		} 
		
		// 60 ~ 69
		if(score < 70 &&score >= 60) {
			grade = 'D';
		}
		
		// ~ 59
		if(score < 60) {
			grade = 'F';
		}
		System.out.printf("점수 : %d, 학점 : %c%n", score, grade);
	}
	
	/**
	 * if(조건식1){실행구문1}
	 * else if(조건식2) {실행구문2}
	 * else if(조건식3) {실행구문3}
	 * ...
	 * else {기본실행구문}
	 * 
	 * 90 ~ 100 : A
	 * 80 ~ 89 : B
	 * 70 ~ 79 : C
	 * 60 ~ 69 : D
	 * ~ 59 : F
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		char grade = ' '; // 공백문자(char타입의 기본값)
		
		// block scope 블럭 유효범위
		// 블럭안에 변수를 선언하면 블럭안에서만 이용 가능하다.
		// 블럭밖에 변수를 선언하면 블럭 안팎에서 모두 이용 가능하다.
		if(score >= 90) {
			grade = 'A';
		} 
		else if(score >= 80) {
			grade = 'B';
		} 
		else if(score >= 70) {
			grade = 'C';
		} 
		else if(score >= 60) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		System.out.printf("점수 : %d, 학점 : %c%n", score, grade);
	}
	
	/**
	 * if(조건식){}
	 * else {}
	 * 
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 살이세요? : ");
		int age = sc.nextInt();
		if(age >= 20) {
			System.out.println("무슨 담배 드릴까요?.");
		} else {
			System.out.println("죄송합니다. 미셩년자는 뒤로 돌아가!");
		}
		System.out.println("--- test2 ---");
	}
	
	/**
	 * if(조건식){}
	 */
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : "); // 50 ~ 100
		int a = sc.nextInt();
		if(a >= 50 && a <= 100) {
			System.out.println("hello~");
		}
		System.out.println("--- test1 end ---");
	}	
}
