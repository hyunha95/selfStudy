package kh.java.test.array;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Test5 t = new Test5();
		t.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		char[] ssc = new char[7];
		System.out.print("주민번호 입력 : ");
		String str = sc.next();
		
		for(int i = 0; i< ssc.length; i++) {
			ssc[i] = str.charAt(i);
			//System.out.print(ssc[i]);
		}
		
		char[] copy = ssc.clone();
		for(int i = 1; i < copy.length; i++) {
			copy[i] = '*';
		}
		
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i]);
		}
		
	}
}


/*
[문제5]
- 클래스 : kh.java.test.array.Test5.java
- 메소드명 : public void test()
    주민등록번호 성별자리 이후부터 *로 가리기.  
	단, 원본 배열값은 변경 없이 배열 복사본으로 
	변경하세요
	힌트) 복사방법
	   - for문이용 1:1대입
	   - System.arraycopy() 매소드 이용
	   - clone() 매소드 이용
*/