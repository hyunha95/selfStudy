package com.kh.test;

public class PrintfStudy {

	public static void main(String[] args) {
		PrintfStudy study = new PrintfStudy();
		study.test1();
		study.test2();
	}
	
	/**
	 * %[flag][width]형식문자
	 * 1. flag생략시 (+) 우측정렬
	 * 2. flag -인 경우 좌측정렬
	 */
	public void test2() {
		int num = 1234;
		System.out.printf("[%10d]%n", num);
		System.out.printf("[%-10d]%n", num);
		
		System.out.printf("[%10s]%n", "한");
		System.out.printf("[%-10s]%n", "a");
		
	}
	
	public void test1() {
		// PrintStream java.io.PrintStream.printf(String format, Object... args) 모든 타입을 쓸 수 있다. 갯수 제한이 없다.
		System.out.printf("포맷문자열 %b %b %n", true, false);
		char ch = '한';
		System.out.printf("char %c %c", ch, '글');
		System.out.printf("정수 %d - %d = %d%n", 123, 456, 123 - 456);
		System.out.printf("실수 %f %.4f%n", 0.123456789, 0.123456789); //6자리까지 이후 반올림
		System.out.printf("문자열 : 제 이름은 %s입니다.%n", "홍길동");
		
		System.out.printf("%s %s %s%n", '한', 1234, 0.1234); //문자열은 모든 타입을 포함할 수 있다.
		
		//printf메소드에서 탭은 \t이다. %t아님. 
		//단, \n도 사용가능하지만, %n이 운영체제에 맞는 개행문자로 치환되므로, %n을 사용하자.
	}
}
