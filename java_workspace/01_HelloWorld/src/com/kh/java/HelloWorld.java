package com.kh.java; //한줄주석 이후로는 JVM이 실행하지 않는다.
//패키지란? 클래스가 저장될 디렉토리
//소문자로 단어단위로 끊어서 작성
//클래스명은 패키지를 포함한다. (com.kh.java.HelloWorld)
//패키지는 중복되지 않도록 웹어플리케이션이 사용할 도메인을 뒤집어서 3레벨 이상으로 사용
// https://java.kh.com

/*
 여러줄주석
 */

/**
 * java doc 주석 : 프로그램 문서에 사용될 주석
 * 클래스, 메소드 레벨에 작성
 *
 */
public class HelloWorld {
	/**
	 * 메인 메소드 : 프로그램 실행시 시작메소드
	 * - 메소드 : 실행할 코드 묶음
	 * 
	 */
	public static void main(String[] args) {
		// 자바에서 취급하는 값(Literal)
		System.out.println("안녕!"); // 문자열 쌍따옴표로 감싸서 처리. 0개 이상의 문자 나열
		System.out.println("");
		System.out.println("안녕!");
		
		System.out.println('a'); // 문자 홑따옴표로 감싸서 처리. 1개의 문자 표현
		System.out.println('한');
		System.out.println('韓');
		
		System.out.println(123); // 정수
		System.out.println(45.67); // 실수
		System.out.println(12 + 34); //계산식
		System.out.println(1234 * 7689);
		
		System.out.println(true); //논리형
		System.out.println(false); //논리형
				
	}
}
