package kh.java.two.dimentional.array;

import java.util.Scanner;

public class JaggedArrayStudy {

	public static void main(String[] args) {
		JaggedArrayStudy study = new JaggedArrayStudy();
//		study.test1();
		study.test2();
	}
	
	/**
	 * 장바구니
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		String[][] cart = new String[3][];
		
		//0행 : 구매할 식료품목록
		System.out.print("1. 구매할 식품목록 개수 : ");
		cart[0] = new String[sc.nextInt()];
		
		//1행 : 구매할 의류목록
		System.out.print("2. 구매할 의류목록 개수 : ");
		cart[1] = new String[sc.nextInt()];
		
		//2행 : 구매할 기타
		System.out.print("2. 구매할 기타목록 개수 : ");
		cart[2] = new String[sc.nextInt()];
		
		// 내용입력
		System.out.println("---------- 내용 입력 ------------");
		for(int i = 0; i < cart.length; i++) {
			
			for(int j = 0; j < cart[i].length; j++) {
				switch(i) {
				case 0 : 
					System.out.print("식료품[" + j + "] : ");
					cart[i][j] = sc.next();
					break;
				case 1 :
					System.out.print("의류[" + j + "] : ");
					cart[i][j] = sc.next();
					break;
				case 2 :
					System.out.print("기타[" + j + "] : ");
					cart[i][j] = sc.next();
					break;
			}
		}
	}
		
		// 내용출력
		for(int i = 0; i < cart.length; i++) {
			
			for(int j = 0; j < cart[i].length; j++) {
				System.out.print(cart[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 가변배열
	 * - 2차원배열이란 타입이 같은 1차원 배열의 묶음.
	 * - 이때 1차원 배열의 길이가 똑같을 필요는 없다.
	 */
	public void test1() {
		int[][] arr = new int[3][];
		
		// int[]을 각 번지에 할당
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[10];
		
		System.out.println(arr[0].toString());
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		int value = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = value++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
