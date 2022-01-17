package com.kh.wrapper;

/**
 * Wrapper
 *	- 동일한 타입으로 부가기능을 제공하는 클래스
 *
 */
public class Main {

	public static void main(String[] args) {
		// 다형성 : 자식객체를 자식타입 또는 부모타입의 변수에 대입해서 제어하는 것
		// 부모타입으로 여러 자식객체를 제어하는 것이 가능하다.
		Peppermint p = new Peppermint();
		Tea t = new Peppermint();
		
//		Dog dog = new Dog();
		Animal dog = new AnimalWrapper(new Dog());
		Animal cat = new AnimalWrapper(new Cat());
		hello(dog);
		hello(cat);
		

	}
	
	public static void hello(Animal animal) {
		// 동적로딩 : 부모타입에서 메소드를 호출하면 오버라이드한 자식메소드가 호출된다.
		System.out.println(animal.say());
	}

}
