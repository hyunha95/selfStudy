package kh.java.oop.access.modifier;

/**
 * 파일명과 동일한 public class는 단하나만 존재할 수 있다. 
 * 클래스의 접근제한자는 public, default만 가능.
 * 
 * 1. public class : 모든 패키지의 클래스에서 접근 가능.
 * 2. default class(비추천) : 접근제한자를 사용하지 않은 경우. 같은 패키지의 클래스에서만 접근 가능
 * 
 * 객체지향프로그래밍에서 클래스를 잘 설계해서 재사용성을 높혀야한다.
 *
 * 
 * 필드/메소드의 접근제한자
 * 1. public : 모든 패키지의 클래스에서 접근 가능
 * 2. protected : 같은 패키지 클래스에서 접근 가능. 다른 패키지여도 자식클래스인 경우 부모클래스는 접근 가능
 * 3. default : 같은 패키지 클래스에서 접근 가능.
 * 4. private : 같은 클래스에서만 접근 가능.
 */
public class Apple {
	public int a = 1;
	protected int b = 2;
	int c = 3;
	private int d = 4;
}

class PineApple {
	
}
