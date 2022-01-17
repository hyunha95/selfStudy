package kh.java.test.array;

import java.util.Scanner;

/*
	{1,2,1} 길이가 3일때, 1번지가 최대
	{1,2,3,2,1} 길이가 5일때 2번지가 최대
	{1,2,3,4,3,2,1} 길이가 7일때, 3번지가 최대
	{1,2,3,4,5,4,3,2,1} 길이가 9일때, 4번지가 최대
	... 길이가 11일때 , 5번지가 최대
	... 길이가 13일때 , 6번지가 최대
 */


public class Test6 {

	public static void main(String[] args) {
		Test6 t = new Test6();
//		t.test1();
		t.test2();
	}
	
	//선생님 풀이
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("홀수인 양의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수는 허용하지 않습니다.");
			return;
		}
		
		int[] arr = new int[num];
		final int HIGH = num / 2; // 기준
		
		for(int i = 0, k = 0; i< arr.length; i++) {
			// 0 1 2 : 1씩 증가하면서 값대입
			if(i <= HIGH) {
				arr[i] = ++k;
			}
			// 3 4 : 1씩 감소하면서 값대입
			else {
				arr[i] = --k;
			}
			System.out.printf("arr[%d] = %d%n", i, arr[i]);
		}
	}
	
	
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("홀수인 양의 정수를 입력하세요 : ");
		int inputNum = sc.nextInt();
		int[] intArr = new int[inputNum];
		if(inputNum%2 == 1) {
			int mid = inputNum/2;
			
			for(int i = 0; i < inputNum; i++) {
				if(i <= mid) {
					intArr[i] = i + 1;
				}
				else {
					intArr[i] = inputNum - i;
				}
				System.out.print(intArr[i]);
			}	
		}
	}
}

/*
[문제6]
- 클래스 : kh.java.test.array.Test6.java
- 메소드명 : public void test()
    배열의 크기로 홀수인 양의 정수를 입력 받아 배열을 만드세요. 
	배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고, 
	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하는 프로그램을 작성하세요.
	출력예시)
	홀수인 양의정수를 하나 입력하세요 ==> 7
	[1, 2, 3, 4, 3, 2, 1]
*/