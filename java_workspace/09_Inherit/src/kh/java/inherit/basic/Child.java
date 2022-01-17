package kh.java.inherit.basic;

/**
 * Child클래스는 Parent의 멤버(필드, 메소드)를 내것처럼 쓸 수 있다.
 */
public class Child extends Parent{

	/**
	 * 메소드 Override
	 * 부로클래스로부터 물려받은 메소드를 다시 작성하는 것
	 * 부모메소드시그니쳐(접근제한자, 리턴타입, 이름, 매개변수선언부)와 동일하게 작성
	 * 
	 * @Override annotation을 사용하면, 시그니쳐가 다를때 컴파일오류를 생성.
	 */
	@Override
	public void say() {
		System.out.println("자식입니다.");
	}
	
	public void doGame() {
		System.out.println("LOL을 시작합니다.");
	}
	
}
