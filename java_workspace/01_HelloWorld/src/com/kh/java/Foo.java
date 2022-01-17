package com.kh.java;

// 다른 패키지의 클래스를 사용시 반드시 작성
import com.kh.java.other.Koo;

public class Foo {

	public static void main(String[] args) {
		// 객체 지향 언어 : 객체를 사용하는 언어
		// 객체란? 메모리 조각
		// 객체 레시피 : 클래스 변수이름 = new 클래스이름();
		Foo foo = new Foo();
		foo.test1(); // 만들어진 객체를 이용해서 메소드 호출
		foo.test2();
		
		Bar bar = new Bar();
		bar.test1();
		
		//다른 패키지에 있는 클래스는 import문을 통해 사용할 수 있다.
		Koo koo = new Koo();
		koo.loo();
	}
	
	
	/**
	 * 일반 메소드
	 */
	public void test1() {
		System.out.println("test111111111111111");
	}
	
	public void test2() {
		System.out.println("test222222222222222");
	}
	
}
