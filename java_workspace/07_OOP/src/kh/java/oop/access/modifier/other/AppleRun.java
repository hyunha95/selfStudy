package kh.java.oop.access.modifier.other;

import kh.java.oop.access.modifier.Apple;

public class AppleRun {

	public static void main(String[] args) {
		// public class는 다른 패키지에서는 import를 통해 사용할 수 있다.
		new Apple();
		
		// default class는 다른 패키지에서는 사용할 수 없다.
//		new PineApple();
		
		Apple apple = new Apple();
		
		//필드 접근 테스트
		System.out.println(apple.a); // public
//		System.out.println(apple.b); // protected
//		System.out.println(apple.c); // default
//		System.out.println(apple.d); // private 접근 불가
	}
}

