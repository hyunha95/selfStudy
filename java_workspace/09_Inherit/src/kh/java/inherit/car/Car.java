package kh.java.inherit.car;

import java.util.Objects;

public class Car {

	private String name;
	private String color;
	
	public Car() {
		super();
	}
	
	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	
	/**
	 * 복사생성자
	 * src객체의 모든 필드값을 새로운 객체의 필드에 복사
	 */
	public Car(Car src) {
		this.name = src.name;
		this.color = src.color;
	}
	
	@Override
	public String toString() {
		return "[name = " + name + ", color = " + color + "]";
	}
	
	/**
	 * 객체의 name, color 필드가 동일하다면, 같은 객체로 간주한다.(동등성)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		Car other = (Car) obj; // Car타입으로 변환
		
		if(!this.name.equals(other.name))
			return false;
		
		if(!this.color.equals(other.color))
			return false;
		
		return true;
	}
	
	/**
	 * hashCode 오버라이딩
	 * equals비교에 사용된 필드값을 이용해 객체고유의 hash값을 만들어낸다.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, color);
	}
	
	/**
	 * Override 특징
	 * 1. 부모클래스의 메소드명, 접근제한자, 리턴타입, 매개변수 선언부는 모두 동일
	 * 2. 부모메소드의 접근제한자를 더 개방하는 쪽으로 변경가능
	 * 		- private(x) -> default -> protected -> public
	 * *private은 다른 클래스에서 사용 불가능하고 default는 거의 없다.
	 * 
	 * 3. override할 수 없는 메소드 :  private(클래스 외부 접근 불가), final(변경불가)
	 * 4. 공변 반환타입 Covariant Return Type : 자식클래스의 타입으로 변경가능
	 * 5. 부모메소드가 던지는 예외클래스의 개수를 줄이거나, 자식예외클래스로 변경 가능
	 * 
	 * 자식메소드를 사용하기 더욱 편리하게 변경하는 것.
	 * 
	 */
	@Override
//	protected Object clone() throws CloneNotSupportedException{
	public Car clone() {
		// 복사생성자
		return new Car(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
