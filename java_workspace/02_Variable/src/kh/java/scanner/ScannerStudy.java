package kh.java.scanner;

import java.util.Scanner;

public class ScannerStudy {

	public static void main(String[] args) {
		
		ScannerStudy study = new ScannerStudy();
		study.test1();
	}
	
	/**
	 * java.util.Scanner
	 * 
	 * 사용자 입력값을 불러오는 객체
	 * 1. next 계열    //공백있는 문자열을 처리할 수 없다.
	 * 		next:String
	 * 		nextInt:int
	 * 		nextDouble:double
	 * 		nextBoolean:boolean
	 * 		···
	 * 		- nextChar는 없다.
	 * 		입력값 이전에 만난 공백/개행문자는 무시하고, 
	 * 		입력값 이후에 처음 만나는 공백/개행문자 전까지만 버퍼에서 읽어옴.
	 * 
	 * 2. nextLine 계열
	 * 		처음만난 개행문자까지 버퍼에서 읽어와서 개행문자를 제거 후 값을 리턴함.
	 * 
	 * 사용자의 키보드 입력은 일단 문자열로 처리되고, 
	 * nextInt, nextDouble등에서 해당타입으로 변환해주는 것
	 * 적절치 못한 값을 입력하면 InputMismatchException이 발생하니 주의할 것.
	 * 
	 */
	public void test1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.println("입력값 : " + name);
		
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		System.out.println("입력값 : " + age + "살");
		
//		System.out.print("키(예 :175.5) : ");
//		double height = sc.nextDouble();
//		System.out.println("입력값 : " + height + "cm");
		
//		System.out.print("결혼여부(true / false) : ");
//		boolean married = sc.nextBoolean();
//		System.out.println("입력값 : " + married);
		
		//문자에 대한 처리 : 문자열을 받아서, 0번지 글자를 가져온다. 
		//"apple"4(5개) "box"2(3개) "pineapple"8(9개)
		//문자열의 마지막인덱스는 (문자열의 길이 -1)과 같다.
		
//		System.out.print("성별 (m/f) : ");
////	String temp = sc.next();
////	char gender = temp.charAt(0);	
//		char gender = sc.next().charAt(0);   
//   	System.out.println("입력값 : " + gender);
		
		//next계열 다음에 nextLine을 사용하는 경우, 개행문자를 버퍼에서 날려줄것.
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine(); //공백이 포함된 문자열은 nextLine으로 처리해야 한다.
		System.out.println("입력값 : " + address);
	}
}









