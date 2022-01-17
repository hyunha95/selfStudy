package kh.java.inherit.basic;

/**
 * 부모클래스를 명시하지 않는다면, Object클래스를 상속하는 것이다.
 *
 */
public class Parent extends Object{
	
	String name;
	int age;
	
	public void say() {
		System.out.println("애비입니다.");
	}
	
	public String info() {
		return name + ", " + age;
	}
}
