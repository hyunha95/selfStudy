package com.kh.test.loop;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Test5 study = new Test5();
		study.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("회원수를 입력하세요 : ");
		int numberOfCustomers = sc.nextInt();
		String[] name = new String[numberOfCustomers];
		int[] age = new int[numberOfCustomers];
		String[] address = new String[numberOfCustomers];
		int[] height = new int[numberOfCustomers];
		int[] weight = new int[numberOfCustomers];
		String[] phoneNumber = new String[numberOfCustomers];
		for(int i = 0; i <numberOfCustomers; i++) {
			System.out.print("이름 : ");
			name[i] = sc.next();
			
			System.out.print("나이 : ");
			age[i] = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("주소 : ");
			address[i] = sc.nextLine();
			
			System.out.print("키 : ");
			height[i] = sc.nextInt();
			
			System.out.print("몸무게 : ");
			weight[i] = sc.nextInt();
			
			System.out.print("연락처 : ");
			phoneNumber[i] = sc.next();
			
			System.out.println();
		}
		System.out.println("========= 저장회원 ==========");
		for(int i = 0; i < numberOfCustomers; i++) {
			System.out.printf("%d %s %d %s %dcm %dkg %s%n", i + 1, name[i], age[i], address[i], height[i], weight[i], phoneNumber[i]);
		}
		double totalAge = 0;
		double totalHeight = 0;
		double totalWeight = 0;
		for(int i = 0; i < numberOfCustomers; i++) {
			totalAge += age[i];
			totalHeight += height[i];
			totalWeight += weight[i];
		}
		System.out.println("=========================");
		for(int i = 0; i <= 0; i++) {
			System.out.printf("평균나이 : %.1f세 / 평균 키 : %.1fCM / 평균 몸무게 : %.1fkg%n", (double)totalAge / numberOfCustomers, (double)totalHeight / numberOfCustomers , (double)totalWeight / numberOfCustomers);
		}
		
		
	}
	
}

/*[문제 5]
- 클래스 : com.kh.test.loop.Test5.java
- 메소드명 : public void test()
	3명의 회원정보를 입력 받아 저장하고 출력하는 
	프로그램을 만드세요
	 입력 : 이름, 나이, 주소, 키, 몸무게, 연락처
	출력 예) 
	================ 저장회원===============
	1 홍길동 19세 서울시 강남구 170cm 68kg 01012345678
	2 임걱정 20세 경기도 수원시 180cm 75kg 01012345678
	//기능추가1
	//출력결과 마지막행에 다음 항목에 대한 평균을 구하시오.
	============================================
	평균나이 00세 / 평균 키 : 00CM / 평균 몸무게 : 00kg
.
	//기능추가2
	//입력할 회원 수를 입력하고 그 수 만큼 회원을 입력 받게 업그레이드 하세요
 */
 


