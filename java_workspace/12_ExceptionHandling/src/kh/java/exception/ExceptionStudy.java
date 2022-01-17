package kh.java.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionStudy {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionStudy study = new ExceptionStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
		
		System.out.println("----- 프로그램 정상 종료 -----");
	}
	
	/**
	 * 예외처리로 프로그램 흐름 만들기
	 */
	public void test5() {
		try {
			checkAge();		
			System.out.println("게임을 시작합니다.");
		} catch(UnderAgeException e) {
			System.err.println(e.getMessage());
			System.out.println("미성년자는 게임을 이용할 수 없습니다.");		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 사용자 나이를 검사해서 20세미만이면 예외를 던짐.
	 */
	public void checkAge() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		if(age < 20)
			throw new UnderAgeException("미성년자입니다 : " + age);
	}
	
//	public void test5() {
//		boolean isAdult = checkAge();
//		
//		if(isAdult) {
//			System.out.println("게임을 시작합니다.");
//		} else {
//			System.out.println("미성년자는 게임을 이용할 수 없습니다.");
//		}
//	}
//	
//	public boolean checkAge() {
//		System.out.print("나이를 입력 : ");
//		int age = sc.nextInt();
//		return age >= 20;
//	}
	
	/**
	 * 사용자 입력값 다시 받기
	 */
	public void test4() {
		while(true) {
			try {
				System.out.print("정수를 입력하세요 : ");
				int n = sc.nextInt();
				System.out.println("입력값 : " + n);	
				
			} catch(InputMismatchException e) {
				System.out.println("올바른 정수를 입력하세요.");
				sc.nextLine(); // 버퍼의 입력값을 제거
				continue;
			}		
			
			break;
		}
	}
	
	/**
	 * catch절과 다형성
	 * - 자식예외에서 부모예외클래스 순으로 catch절을 작성해야 한다.
	 */
	public void test3() {
		
		try {
			System.out.print("정수1 : ");
			int a = sc.nextInt();
			System.out.print("정수2 : ");
			int b = sc.nextInt();
			System.out.printf("%d + %d = %d%n", a, b, a + b);
			System.out.printf("%d - %d = %d%n", a, b, a - b);
			System.out.printf("%d * %d = %d%n", a, b, a * b);
			System.out.printf("%d / %d = %d%n", a, b, a / b);
			
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
			e.printStackTrace();
		} catch(InputMismatchException e) {
			System.out.println("올바른 정수를 입력하세요.");
			e.printStackTrace();			
//		} catch(RuntimeException e) {
//			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * try...catch 실행흐름
	 */
	public void test2() {
		System.out.println(1);
		
		try {
			System.out.println(2);
			
			int[] arr = new int[10];
//			System.out.println(arr[100]);
			
			System.out.println(3);
			
			if(true) 
				return;
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(4);
		} finally {
			//try절 실행에서 예외가 발생하든 안하든 무조건 실행되는 구문
			//자원반납 코드
			System.out.println(5); 			
		}
		System.out.println(6);
	}
	
	/**
	 * Exception
	 * 	예외처리 코드에 의해서 적절히 수습할 수 있는 미약한 오류.
	 * 
	 * - 1. unchecked exception 
	 * 			- RuntimeException의 후손클래스
	 * - 2. checked exception
	 * 			- RuntimeException의 후손이 아닌 클래스
	 * 			- 예외처리(try...catch)를 강제화.
	 */
	public void test1() {
		
		try {
			//예외가 발생할 수 있는 코드
			//try안에서 예외가 발생한 이후에 코드는 실행하지 않는다
			String s = null;
			System.out.println(s.length());
	 		
			int[] arr = new int[10];
			System.out.println(arr[10]);
			
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			int result = num1/ num2;
			System.out.printf("%d / %d => %d%n",num1, num2, result);
			
		} catch(NullPointerException e) {
			System.out.println("null인 변수를 참조할 수 없습니다.");
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 번지를 잘못 참조하셨습니다.");
			
		} catch(InputMismatchException e) {
			// 예외가 발생하면 예외객체가 catch의 변수에 담기고, catch절이 실행된다.
			// catch절 실행후에 프로그램은 다시 정상작동한다.
			System.out.println("정수만 입력하세요.");
			
			// 예외객체 정보 및 메소드 호출스택 정보를 출력
			e.printStackTrace();
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			
			// 예외객체 정보
			System.out.println(e.getMessage()); // / by zero
			
			e.printStackTrace();
		}
	}
}
