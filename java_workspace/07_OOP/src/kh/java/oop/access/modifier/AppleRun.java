package kh.java.oop.access.modifier;

public class AppleRun {

	public static void main(String[] args) {
		// 같은 패키지에서는 import없이 사용할 수 있다.
		Apple apple = new Apple();
		new PineApple();
		
		//필드 접근 테스트
		System.out.println(apple.a); // public
		System.out.println(apple.b); // protected
		System.out.println(apple.c); // default
//		System.out.println(apple.d); // private 접근 불가
	}
}

