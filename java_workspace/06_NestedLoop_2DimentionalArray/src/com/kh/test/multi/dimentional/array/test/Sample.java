package com.kh.test.multi.dimentional.array.test;

/**
 * /*
 * [2차원 배열 실습문제]
 - 클래스 생성 : com.kh.test.multi.dimentional.array.test.Sample.java
[문제 1]
 - 메소드명 : public void exercise1()
 - 구현내용 : 
	1. 3행 5열 2차원배열 선언 및 생성
	2. 1~100사이의 임의의 정수를 모든 방에 기록함
	3. 열의 값이 5의 배수인 경우만 값(행,열) 출력함
[문제 2]
 - 메소드명 : public void exercise2()
 - 구현내용 : 
	1. 3행4열 2차원배열 선언 및 생성
	2. 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록해 넣음
	3. 아래의 내용처럼 처리함
		0열	1열	2열	3열	
	0행	값	값	값 	0행 값들의 합계
	1행	값	값	값	1행 값들의 합계
	2행	값	값	값	2행 값들의 합계
심화)
	4행4열 2차원배열로 변경한뒤, 3행에 다음 내용추가
	3행	0열합계	1열합계	2열합계	난수총합

 */

public class Sample {


	public static void main(String[] args) {
		Sample s = new Sample();
//		s.exercise1();
//		s.exercise2();
		s.exercise2_();
	}
	
	
	/* 다른 풀이
	 public void exercise2_() {
		int[][] arr = new int[3][4];
		for(int i = 0; i < arr.length; i++) {
			int rowSum = 0; //각행마다 0, 1, 2 열의 수를 누적할 변수
			for(int j = 0; j < arr[i].length; j++) {
				// 0 1 2열
				if(j < 3) {
					arr[i][j] = (int)(Math.random() * 100) + 1;					
					rowSum += arr[i][j]; // 이번행의 값을 누적
				}
				else {
					arr[i][j] = rowSum;
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	 */
	
	/*
		 	0열	1열	2열	3열	
		0행	값	값	값 	0행 값들의 합계
		1행	값	값	값	1행 값들의 합계
		2행	값	값	값	2행 값들의 합계 
	 */
	//선생님 풀이
	public void exercise2_() {
		int[][] arr = new int[3][4];
		
		for(int i = 0; i < arr.length; i++) {
			
			
			for(int j = 0; j < arr[i].length; j++){
				// 0 1 2열
				if(j < 3) {
					arr[i][j] = (int)(Math.random() * 100) + 1;	
				}
				else {
					arr[i][j] = arr[i][0] + arr[i][1] + arr[i][2]; // 3열이 정해져 있으므로 직접 계산
				}
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public void exercise1() {
		int[][] arr = new int[3][5];
		int result;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 100) + 1;
				//System.out.print(arr[i][j] + " ");
				if(arr[i][j] % 5 == 0) {
					System.out.printf("%d(%d, %d)%n", arr[i][j], i, j);
				}
			}
		}
	}
	
	public void exercise2() {
		int[][] arr = new int[3][4];
		//0행 0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록해 넣음
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = (int)(Math.random() * 100) + 1;
				//0, 1, 2행 값들의 합계
				arr[i][3] += arr[i][j]; 
			}
		}
		
		//출력하기
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("심화");
		arr = new int[4][4];
		//0행 0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록해 넣음
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = (int)(Math.random() * 100) + 1;
			}
		}
		
		// 열과 행의 합 계산하기
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr[i].length - 1; j++) {
				//0, 1, 2행 값들의 합계
				arr[i][3] += arr[i][j]; 
				
				//0, 1, 2열 값들의 합계
				arr[3][i] += arr[j][i];
			}
		}
		
		//출력하기
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

