package kh.java.array.sort;

import java.util.Arrays;

/**
 * 
 * 배열 정렬
 * { 3, 2, 4, 5, 1} => { 1, 2, 3, 4, 5}
 * 어떤 정렬 알고리즘을 사용하는냐에 따라 연산속도 등 효율성이 달라진다.
 * 좋은 알고리즘(일을 처리하는 절차)이란 더 적은 시간에, 더 적은 메모리를 사용해 같은 결과를 도출하는 것.
 *
 * - 순차정렬
 * - 선택정렬
 * - 버블정렬
 * - 삽입정렬
 * - 퀵정렬
 * - 합병정렬...
 *
 */
public class ArraySortStudy {

	public static void main(String[] args) {
		ArraySortStudy study = new ArraySortStudy();
//		study.test1();
		study.test2();
//		study.test3();
//		study.test4();
	}
	
	/**
	 * 버블정렬 Bubble Sort
	 * - 인접한 두요소를 검사하고 정렬하는 방법
	 * 
	 */
	public void test4() {
		int[] arr = {50, 40, 10, 30, 20};
		
		System.out.println(Arrays.toString(arr));
		
		// i는 안쪽 반복문 반복횟수 4 3 2 1
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
				printArr(i, arr);
			}
		}
	}
	
	/**
	 * 선택정렬 Selection Sort
	 * - 매 회차에 최소값에 해당하는 인덱스를 찾고, 회차 마지막에 딱 1회 자리변경함.
	 * 
	 */
	public void test3() {
		int[] arr = {50, 40, 10, 30, 20};
		
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i; // 최소값에 해당하는 인덱스
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
				printArr(i, arr);
			}
			swap(arr, min, i);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 순차정렬 Sequential Sort
	 * - 반복문 1턴이 끝나면 해당 인덱스는 알맞은 숫자를 찾게된다.
	 * - 각 턴마다 가장 작은수를 찾게된다.
	 */
	public void test2() {
		int[] arr = {4, 3, 0, 2, 1};
		
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
				printArr(i, arr);
			}
		}
	}
	
	public void printArr(int i, int[] arr) {
		System.out.printf("%d : %s%n", i, Arrays.toString(arr));
	}
	
	/**
	 * 변수의 자리바꿈
	 * 배열요소의 자리바꿈
	 */
	public void test1() {
		int x = 10;
		int y = 20;
		
		//x의 값을 임시보관할 변수 선언
		int temp = x;
		x = y;
		y = temp;
		
		
		System.out.println("x = " + x + ", y = " + y); // x = 20, y = 10
		
		int[] arr = {2, 1, 3};
		
//		temp = arr[0];
//		arr[0] = arr[1];
//		arr[1] = temp;
	
		swap(arr, 0, 1);
		
		System.out.println(Arrays.toString(arr)); // 배열 요소 확인
	}
	
	
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}









