package kh.java.test.array;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Test4 t = new Test4();
//		t.test1();
		t.test2();
	}
	
	/**
	 * 문자열에서 가운데 4자리 * 처리하기
	 * "01012341234" -> "010****1234"
	 * 
	 * String운 불변(immutable)이다.
	 */
	public void test2() {
		String s = "01012341234";
		// String java.lang.String.substring(int beginIndex, int endIndex)
		String tel1 = s.substring(0, 3);
		String tel2 = "****";
		String tel3 = s.substring(7);
		
		System.out.println(tel1 + tel2 + tel3);
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호를 입력하세요 : ");
		String str = sc.next();
		
		// char[] cArr = phNum.toCharArray(); //자바는 문자열을 char[]로 변환하는 메소드를 제공한다.
		char[] number = new char[11];
		for(int i = 0; i < number.length; i++) {
			number[i] = str.charAt(i);
			//System.out.print(number[i]);
		}
		
		char[] copy = number.clone();
		for(int i = 3; i <= 6; i++) {
			copy[i] = '*';
		}
		
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i]);
		}
	}
}

/*
[문제4]
- 클래스 : kh.java.test.array.Test4.java
- 메소드명 : public void test1()
    사용자의 전화번호를 입력받고, 11자리의 문자형배열에 저장한후,  가운데 4자리를 *로 가리기.  
	단, 원본 배열값은 변경 없이 배열 복사본으로 변경하세요
		힌트) 복사방법
	   - for문이용 1:1대입
	   - System.arraycopy() 매소드 이용
	   - clone() 매소드 이용
 */
