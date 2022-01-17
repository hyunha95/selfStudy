/*실습문제
 * 
 * 1. 각 자료형별 변수를 만들고 초기화한 후 그 값을 출력하는 코드를 작성해 보자.
 	- 정수형 100, 9999억, 
   	- 실수 486.567(float), 567.890123
   	- 문자 A
   	- 문자열 Hello world, 
   	- 논리 true
     단, 변수를 이용하여 출력하시오 .
 	com.kh.test.Test1 에 작성
2. 자신의 신상정보를 저장할 변수를 만들고 정보를 변수에 대입, 출력하는 프로그램을 작성하세요.
(System.out.printf 메소드 학습후 사용할것.)
 	- 이름, 나이, 성별,주소, 전화번호, 이메일      
=======================================================================
이름		나이	성별 	  전화번호			이메일			주소
=======================================================================
홍길동		22		남		01012341234	   hgd@naver.com	경기도 광주시
홍길순		20		여		010123412341   hgs@gmail.com	전라남도 광주시							
작성한 변수를 재사용해 팀메이트의 정보를 다시 변수에 대입 출력하는 프로그램으로 수정하세요.
com.kh.test.Test2 에 작성
 * 
 */

package com.kh.test;

public class Test2 {

	public static void main(String[] args) {
	
		String name = "홍길동";
		int age = 22;
		String s = "남";
		String phoneNumber = "01012341234";
		String email = "hgd@naver.com";
		String address = "경기도 광주시";
		
		System.out.println("====================================================================");
//		System.out.printf("이름\t나이\t성별\t전화번호\t\t이메일\t\t주소");
		System.out.printf("%10s%10s%10s%20s%20s%30s", "이름","나이","성별","전화번호","이메일","주소");
		System.out.println("");
		System.out.println("====================================================================");
		System.out.printf("%10s%10s%10s%20s%20s%30s", name, age, s, phoneNumber, email, address);
		System.out.println("");
		
		name = "홍길순";
		age = 20;
		s = "여";
		phoneNumber = "010123412341";
		email = "hgs@gmail.com";
		address = "전라남도 광주시";
		System.out.printf("%10s%10s%10s%20s%20s%30s", name, age, s, phoneNumber, email, address);	
	}
}
