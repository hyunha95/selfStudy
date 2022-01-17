package kh.java.basic;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberStudy {

	public static void main(String[] args) {
		RandomNumberStudy study = new RandomNumberStudy();
//		study.test1();
		study.test2();
//		study.test3();
	}
	
	/**
	 * 동전게임
	 */
	public void test3() {
		// 컴퓨터 : 동전 던지기 (앞/뒤)
		int com = (int)(Math.random() * 2) + 1; // 앞 1, 뒤 2
		
		// 사용자 : 베팅하기
		Scanner sc = new Scanner(System.in);
		System.out.println("동전은 앞일까요? 뒤일까요? 1. 앞 2. 뒤 : ");
		int user = sc.nextInt();
		
		// 결과확인
		System.out.println(com == user ? "맞췄습니다." : "땡~");
	}
	
	/**
	 * 난수2. java.lang.Math
	 * - random():double
	 */
	public void test2() {
		double n = Math.random(); // 0.0 이상 1.0 미만의 실수를 리턴
//		System.out.println(n);
		
//		int num = (int)(Math.random() * 10) + 1; // 1 ~ 10 사이의 정수
		int num = (int)(Math.random() * 20) + 11; // 11 ~ 30 사이의 정수
		System.out.println(num);
		
		boolean bool = (int)(Math.random() * 2) == 0;
		System.out.println(bool);
	}
	
	/**
	 * 난수1. java.util.Random
	 * - 정수형 난수
	 * - 실수형 난수
	 * - boolean형 난수
	 */
	public void test1() {
//		java.util.Random rnd = new java.util.Random();
		Random rnd = new Random();
//		int num = rnd.nextInt(); // 범위를 지정하지 않으면, 정수범위내에서 난수 추출
//		int num = rnd.nextInt(10); // 경우의 수 - 10가지(0 ~ 9)
		int num = rnd.nextInt(20) + 11; // 11 ~ 30  (범위) + 시작값
		System.out.println(num);
		
		double n = rnd.nextDouble(); // 0.0 이상 1.0 미만의 실수를 리턴
		System.out.println(n);
		
		boolean bool = rnd.nextBoolean();
		System.out.println(bool);
	}
}
