package kh.java.array;

import java.util.Scanner;

public class ArrayStudy {

	public static void main(String[] args) {
		ArrayStudy study = new ArrayStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	/**
	 * 배열의 특징
	 * 1. 배열은 객체다 -> heap영역에 생성된 메모리조각
	 * 2. 생성된 배열의 크기를 변경할 수 없다.
	 * 
	 */
	public void test5() {
//		double arr[] = new double[4];
		double[] arr = new double[4];
		double[] other = new double[4];
		
		System.out.println(arr.hashCode());

		arr = new double[10];
		
		//객체는 hashCode을 가진다. 객체를 식별하기 위한 고유한 코드.
		System.out.println(arr.hashCode());
//		System.out.println(other.hashCode());
		
		// 객체삭제 : heap영역의 객체는 직접 삭제가 불가능하다.
		// 참조변수에 담긴 주소값 삭제는 가능하다.
		// 연결이 끊어진 객체들을 garbage collector에 의해 반환(삭제)된다.
		double[] copy = arr;
		arr = null; // 가리키는 주소값 없음.
		
		System.out.println(arr);
		
		System.out.println("copy = " + copy); // 객체가 문자열(text)로 처리되어야 할때. 자동호출되는 메소드
		System.out.println(copy.toString());
		
		//참조변수가 가리키는 객체가 없을 때(null) 참조변수를 이용해 속성을 참조하거나, 메소드를 호출하면
		// NULLPointerException이 발생한다.
		//System.out.println(arr.hashCode());
		//System.out.println(arr.length);
	}
	
	/**
	 * 크기가 100개인 정수형 배열에
	 * 1 ~ 100을 차례로 대입할 것.
	 * 
	 * 출럭 : 1, 2, 3, 4, 5, ...98, 99, 100
	 */
	public void test4() {
		int[] arr = new int[100];
		
		// 입력
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			}
		//출력
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(i != arr.length - 1 ? ", " : "");
		}
	}
	
	/**
	 * 사용자 이름을 입력받은 후,
	 * 문자열의 길이와 동일한 char[]을 생성, 각 번지수에 맞는 문자를 대입하세요.
	 * 
	 * char[] 출력
	 */
	public void test3() {
		//1. 사용자 입력 -> String
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		//2. char[]생성 : 문자열의 길이를 리턴하는 메소드는 ?
		char[] arr = new char[name.length()];
		
		//3. char[]의 길이만큼 반복문 순회
		for(int i = 0; i < arr.length; i++) {
			//각 인덱스마다 문자열의 문자를 char[]에 대입
			arr[i] = name.charAt(i);
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * 초기화 : 배열선언과 동시에 특정값으로 할당된 배열을 생성
	 * 
	 * forEach 반복문
	 * for(요소를 담을 매개변수 : 반복접근이 가능한 객체){
	 * 
	 * }
	 */
	public void test2() {
//		int[] arr = new int[10];
//		int[] arr = {12, 34, 5, 7, 8};
		int[] arr = new int[] {12, 34, 5, 7, 8}; // 배열크기를 지정하지 말것 // 이거 쓰지 말것
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		// index사용이 필요없는 경우
		for(int n : arr) {
			System.out.println(n);
		}
	}
	
	/**
	 * 배열 
	 * 같은 타입의 여러개의 값을 제어할 수 있는 메모리상의 연속된 공간을 사용한다.
	 */
	public void test1() {
		// 1. 배열 선언
		int[] arr;
		char[] chArr;
		
		// 2. 배열 할당 : heap메모리에 연속된 공간 할당 후 주소값을 변수에 대입
		// 배열 길이를 반드시 지정
		// 각 공간은 타입별 기본값(타입별 0에 해당하는 값)으로 설정된다.
		// int - 0, double - 0.0, char - ' ', boolean - false
		arr = new int[4];
		chArr = new char[10];
		
		// 3. 각번지에 값 지정
		// 좌항의 공간에 우항의 값을 대입!
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		chArr[0] = '가';
		chArr[1] = '나';
		chArr[2] = '다';
		chArr[3] = '安';
		chArr[4] = '多';

		// 4. 배열 요소 확인
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
//		System.out.println(arr[3]); // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		
		System.out.println("[" + chArr[0] + "]");
		System.out.println("[" + chArr[1] + "]");
		System.out.println("[" + chArr[2] + "]");
		System.out.println("[" + chArr[3] + "]");
		System.out.println("[" + chArr[4] + "]");
		
		// 반복문 통해 배열 접근하기 //무조건 0부터 시작해야함
		System.out.println("arr.length = " + arr.length);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 100;
			System.out.println(arr[i]);
		}
		
		// chArr 모든 요소 열람 
		for(int i = 0; i < chArr.length; i++) {
			System.out.println("[" + chArr[i] + "]");
		}
	}

}

















