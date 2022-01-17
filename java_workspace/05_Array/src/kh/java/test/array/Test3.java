package kh.java.test.array;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next();
		char[] chArr = new char[str.length()];
		
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
		}
		
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.next().charAt(0);
		
		int sum = 0;
		for(int i = 0; i < chArr.length; i++) {
			if(chArr[i] == ch) {
				sum += 1;
			}
		}
		System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개 입니다.", str, ch, sum);
	}
}

/*
 [문제3]
- 클래스 : kh.java.test.array.Test3.java
- 메소드명 : public void test()
    문자열을 하나 입력 받아 문자배열에 넣고 검색할 문자를 하나 입력 받아 검색 문자가 문자열에 몇 개인지 개수를 출력하는 프로그램을 작성하세요.
	예) 입력값 : helloworld
	검색값 :ㅣ
	출력 : 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다.
 */
