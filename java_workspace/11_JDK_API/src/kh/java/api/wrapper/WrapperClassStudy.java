package kh.java.api.wrapper;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassStudy {

	public static void main(String[] args) {
		WrapperClassStudy study = new WrapperClassStudy();
		study.test1();
//		study.test2();

	}
	
	/**
	 * String에서 해당타입으로 형변환 메소드
	 */
	private void test2() { 
		boolean bool = Boolean.valueOf("true");
//		boolean bool = Boolean.parseBoolean("true"); // valueof랑 동일하다
		int i = Integer.parseInt("134234");
//		int i = Integer.valueOf("134234");
		double d = Double.parseDouble("23.456");
//		double d = Double.valueOf("23.456");
		char ch = "a".charAt(0);
		
	}

	/**
	 * wrapper class
	 * - 기본형에 대응하는 java.lang패키지 클래스
	 * - 기본형의 값을 감싸서 객체로 반환.
	 * 
	 * boolean -> Boolean
	 * 
	 * char -> Character
	 * 
	 * byte -> Byte
	 * short -> Short
	 * int -> Integer
	 * long -> Long
	 * 
	 * float -> Float
	 * double -> Double
	 * 
	 * 형변환은 거의 자동으로 처리된다.
	 * - auto-boxing : 기본형 -> Wrapper참조형
	 * - auto-unboxing : Wrapper참초형 -> 기본형
	 * 
	 */
	private void test1() {
		int num = 100;
		Integer iNum = new Integer(100);
		System.out.println(Integer.MAX_VALUE);
		
		//연산
		System.out.println(num + iNum); // int + Integer -> iNum.intValue() : auto-unboxing
		System.out.println(num + iNum.intValue());
		
//		Integer n = 50; // Integer = int : auto-boxing
		Integer n = Integer.valueOf(50);
		
		Integer x = 3;
		Integer y = 7;
		System.out.println(x + y); // Integer + Integer -> int + int
		
		
		// 기본형이 아닌 참조형만 사용이 가능한 Generics문법
		List<Integer> list = new ArrayList<Integer>();
		
	}

}















