package kh.java.inherit.car;

public class CarMain {

	public static void main(String[] args) {
		CarMain main = new CarMain();
//		main.test1();
		main.test2();
//		main.test3();

	}
	
	/**
	 * 객체를 복제하는 clone 오버라이드
	 */
	public void test3() {
		Car car = new Car("그랜져", "크리스탈화이트");
		// protected java.lang.Object.clone() -> public kh.java.inherit.car.Car.clone()
		Car another = car.clone();
		
		System.out.println(car == another); // 동일성 비교 false
		System.out.println(car.equals(another)); // 동등성 비교 true
	}
	
	/**
	 * 객체간 동등성을 비교하는 equals & hashCode 오버라이드
	 * 
	 * - 동등성 equality 객체의 내용이 같은가?
	 * - 동일성 identity 같은 주소값을 가진 객체인가?
	 * 
	 * equals의 비교결과가 true인 경우, hashCode값 또한 동일해야 한다. 
	 * 
	 */
	public void test2() {
		Car car1 = new Car("소나타", "사파이어블랙");
		Car car2 = new Car("소나타", "사파이어블랙");
		Car car3 = car1;
		Car car4 = new Car("소나타", "사파이어골드");
		
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		
		//동일성 비교
//		System.out.println(car1 == car2); // false //메모리의 주소값 비교
//		System.out.println(car1 == car3); // true
		
		//동등성 비교 : equals
		System.out.println(car1.equals(car2)); // true
//		System.out.println(car1.equals(car4)); // false
		
		
	}
	
	/**
	 * toString()
	 */
	public void test1() {
		Car car1 = new Car("소나타", "사파이어블랙");
		Car car2 = new Car("카니발", "엠파이어화이트");
		
		System.out.println(car1.getName()); // 소나타
		System.out.println(car1.getColor()); // 사파이어블랙
		
		System.out.println(car1);
		System.out.println(car1.toString());
		
	}

}
