package kh.java.basic;

import java.util.Scanner;

public class MethodStudy {

	public static void main(String[] args) {
		MethodStudy study = new MethodStudy();
//		study.test1();
//		study.test2();
		study.test3();
	}
	
	/**
	 * @실습문제: 친구3명의 이름을 입력받고 아래와 같이 출력하세요.
	 * 
	 * 친구1 입력하세요 : 홍길동
	 * 친구2 입력하세요 : 고길동
	 * 친구3 입력하세요 : 마길동
	 * ---------------------
	 * 당신의 친구는 [홍길동, 고길동, 마길동]입니다.
	 */
	public void test3() {
		String f1 = inputFriendName(1);
		String f2 = inputFriendName(2);
		String f3 = inputFriendName(3);
		System.out.printf("당신의 친구는 [%s, %s, %s]입니다.%n", f1, f2, f3);
	}
	
	public String inputFriendName(int n) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("친구%d : ", n);
		return sc.next();
	}
	
	/**
	 * 0개 또는 1개의 리턴값을 가질 수 있다.
	 */	
	public void test2() {
		int num1 = inputNumber();
		int num2 = inputNumber();		
		
		System.out.printf("합 : %d%n", num1 + num2);
		
		return; // void 메소드의 마지막에는 return구문이 생략되어 있다.
	}
	
	public int inputNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	
	public void printPerson(String name, int age) { //매개변수
		System.out.printf("이름 : [%s]%n나이 : [%d]세%n", name, age);
	}
	
	/**
	 * 매개변수 : 메소드 선언부에 작성된 변수(공간)
	 * 매개인자 : 메소드 호출부에 전달된 값
	 * 
	 * 메소드 호출시 전달된 매개인자가 메소드 선언부의 매개변수에 대입된다.
	 * 
	 * 호출시 매개변수의 타입, 개수, 순서를 정확하게 지켜야 한다.
	 * 
	 */
	public void test1() {
		String name = "홍길동";
		int age = 30;
		printPerson(name, age); //매개인자
//		printPerson(name);
//		printPerson(age);
//		printPerson(age, name);
//		printPerson();
		
		name = "신사임당";
		age = 50;
		printPerson(name, age);
		
		name = "세종대왕";
		age = 72;
		printPerson(name, age);
	}
}














