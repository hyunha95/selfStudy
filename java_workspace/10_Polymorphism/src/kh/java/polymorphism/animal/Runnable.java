package kh.java.polymorphism.animal;

/**
 * 인터페이스(규격)
 * - 상수 (public static final) int LENGTH = 3;
 * - 추상메소드
 * 
 * 멤버필드, 멤버메소드는 가질 수 없다.
 * 객체화 할 수 없다. new Runnable() (x)
 * 
 * Foo -------------> Runnable (실체화관계) Foo가 Runnable을 구현했다.
 * public class Foo implements Runnable, Barkable,... {}
 * - 다중구현을 지원한다.
 * - 인터페이스는 다른 인터페이스를 상속할 수 있다. public interface Foo extends Bar {}
 *
 */
public interface Runnable {
	//상수
//	public static final 생략가능
	int LEN_OF_LEGS = 4; 
	
	//추상메소드
//	public abstract 생략가능
	void run();

}
