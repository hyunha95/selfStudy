package kh.java.polymorphism.animal;

/**
 * 추상메소드를 통한 자식클래스의 overriding 강제화
 * 1. 추상클래스 - 추상메소드 (일반클래스 + 규격)
 * 2. 인터페이스 - 추상메소드 (규격) + default/static메소드(jdk8)
 * 
 * 추상클래스
 * - 0개이상의 추상메소드를 가진 클래스
 * - 객체화 할 수 없다. new Animal() (x) --> 자식클래스에 대한 규격으로만 사용할 것.
 * - 일반멤버(필드/메소드)를 가질 수 있다.
 * 
 * 자식클래스에 물려줄 멤버변수/메소드가 있어야 하는 경우는 추상클래스를 사용.
 * 자식클래스에 물려줄 멤버변수/메소드가 없는 경우는 인터페이스를 사용.
 * 
 */
public abstract class Animal {

	/**
	 * 추상메소드(미완성메소드) - 자식클래스에서 반드시 구현해야 할 메소드
	 * - abstact키워드 필요. 
	 * - 접근제한자, 리턴타입, 매개변수 선언부는 자식메소드에서 그대로 작성
	 * - 몸통을 작성하지 않는다.
	 * - 추상메소드를 하나이상 가진다면 해당클래스는 반드시 추상클래스여야 한다.
	 */
	public abstract void say();
//	public void say() {
//		System.out.println("안녕하세요, 동물입니다.");
//	}
	
	public abstract void attack();
	
}
