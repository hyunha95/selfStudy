package kh.java.polymorphism.animal;

import java.util.Random;

public class AnimalMain {

	public static void main(String[] args) {
		
		AnimalMain main = new AnimalMain();
//		main.test1();
//		main.test2();
//		main.test3();
//		main.test4();
//		main.test5();
//		main.test6();
		main.test7();

	}
	
	/**
	 * Eagle클래스
	 * - Animal을 상속
	 * - Flyable인터페이스를 구현
	 * 		- fly()
	 * 
	 *  say호출 "안녕하세요, 이글이글입니다."
	 *  fly호출 "독수리가 2날개로 시속128km로 납니다."
	 */
	public void test7() {
		Flyable eagle = new Eagle();
		((Animal) eagle).say();
		eagle.fly();
	}
	
	/**
	 * 인터페이스 타입으로 자식객체 제어하기
	 * 
	 */
	public void test6() {
		Runnable tiger = new Tiger();
		Runnable lion = new Lion();
		
		tiger.run();
		lion.run();
		
		((Animal) tiger).say();
		((Tiger) tiger).kick();
		
		Runnable[] runArr = new Runnable[5]; //객체를 만든게 아니라 배열은 만든거다
		runArr[0] = new Tiger();
		runArr[1] = new Lion();
		runArr[2] = new Tiger();
		runArr[3] = new Lion();
		runArr[4] = new Tiger();
		
		for(Runnable r : runArr)
			r.run();
	}
	
	/**
	 * 정적바인딩 : 메소드 호출시 해당객체의 타입에 따라 호출되는 것. 컴파일타입 확인 가능
	 * 		- Tiger -> punch
	 * 		- Animal -> say
	 * 동적바인딩 : 부모타입의 참조변수에서도 실제 생성된 객체타입(자식)의 메소드를 형변환없이 실행.
	 * - 상속 
	 * - 메소드 오버라이딩
	 */
	public void test5() {
		Animal a1 = new Tiger();
		a1.say();
		
		Animal a2 = new Lion();
		a2.say();
		
		Animal[] arr = new Animal[2];
		arr[0] = new Tiger();
		arr[1] = new Lion();
		
		for(int i = 0; i < arr.length; i++) {
			Animal animal = arr[i];
			animal.say();
			animal.attack(); // Tiger객체 - Tiger.attack, Lion객체 - Lion.attack
		}
	}
	
	/**
	 * 2. 리턴타입에서 다형성 활용하기
	 */
	public void test4() {
		Random rnd = new Random();
		Animal animal = rnd.nextBoolean() ? getTiger() : getLion();
//		Animal animal = new Tiger();
//		Animal animal = new Lion();
		System.out.println(animal);
	}
	
	public Tiger getTiger() {
		return new Tiger();
	}
	
	public Lion getLion() {
		return new Lion();
	}
	
	/**
	 * 1. 매개변수에서 다형성 활용하기
	 */
	public void test3() {
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		
		attack(tiger);
		attack(lion);
	}
	
	/**
	 * Animal animal = tiger;
	 * Animal animal = lion;
	 */
	public void attack(Animal animal) {
		if(animal instanceof Tiger) {
			((Tiger) animal).kick();
		}
		else if(animal instanceof Lion) {
			((Lion) animal).punch();
		}
	}
	
//	public void attack(Tiger tiger) {
//		
//	}
//	
//	public void attack(Lion lion) {
//		
//	}
	
	/**
	 * 다형성의 효용
	 * - 부모클래스는 자식클래스의 공통된 규격을 제공한다.
	 */
	public void test2() {
		Animal[] arr = new Animal[4];
		arr[0] = new Tiger();
		arr[1] = new Lion();
		arr[2] = new Tiger();
		arr[3] = new Lion();
		
		for(int i = 0; i < arr.length;i++) {
			Animal animal = arr[i]; // up-casting
			
			// 객체 instanceof 클래스 : 현재객체가 해당클래스타입이라면 true
			// 해당 타입으로 형변환 오류없이 할 수 있다.
			if(animal instanceof Tiger) {
				((Tiger)animal).kick(); // down-casting				
			}
			else if(animal instanceof Lion) {
				((Lion) animal).punch(); 				
			}
		}
		
		Tiger tiger = new Tiger();
		System.out.println(tiger instanceof Tiger);
		System.out.println(tiger instanceof Animal);
		System.out.println(tiger instanceof Object);
		
		// 해당타입의 객체인 것을 확인할 수 있다.
		System.out.println(tiger.getClass() == Tiger.class);
	}
	
	/**
	 * 다형성
	 * - 생성된 객체 타입뿐아니라 부모타입의 참조변수에 담아서 객체를 제어할 수 있다.
	 * - 해당타입 안에 선언된 필드/메소드만 사용가능
	 * 
	 * 형변환
	 * - up-casting : 부모타입으로 변경. 자동형변환
	 * - down-casting : 자식타입으로 변경. 명시적형변환
	 * 
	 */
	public void test1() {
		Tiger t = new Tiger();
		Animal a = t;
		Object o = t;
		
		// Tiger타입으로 제어
		t.kick();
		t.say();
		System.out.println(t.toString());
		System.out.println("-------------------");
		
		// Animal타입을 제어 - tiger.kick 사용불가
//		a.kick();
		a.say(); // 자식클래스에서 재정의되어서 자식클래스의 매소드가 대신 호출됨
		System.out.println(a.toString());
		System.out.println("-------------------");
		
		// Object타입으로 제어
//		o.kick();
//		o.say();
		System.out.println(o.toString());
		
		// 다시 Tiger타입으로 변경
		Tiger tigerAgain = (Tiger) o; // down-casting
		tigerAgain.kick();
		tigerAgain.say();
		
		// Lion객체에 다형성 적용하기
		Animal lion = new Lion();
//		Lion lionAgain = (Lion) lion;
//		lionAgain.punch();
		((Lion) lion).punch();
//		.의 연산순서가 더 빠르기 때문에 괄호를 묶어준다.
		
		// Lion객체를 Tiger타입으로 제어할 수 있는가? X
//		Tiger maybeTiger = (Tiger) lion;
		// java.lang.ClassCastException: class kh.java.polymorphism.animal.Lion cannot be cast to class kh.java.polymorphism.animal.Tiger (kh.java.polymorphism.animal.Lion and kh.java.polymorphism.animal.Tiger are in unnamed module of loader 'app')
		
		// Animal객체를 Tiger타입으로 제어할 수 있는가? X
//		Tiger maybeTiger = new Animal();
		
	}

}
