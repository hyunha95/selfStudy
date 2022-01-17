package kh.java.oop.student;

/**
 * class의 설계대로 객체(instance)가 만들어진다.
 * 
 * 1. 속성 field
 * 2. 기능 method
 * 
 * VO클래스 Value Object
 *  - 데이터를 저장할 목적의 클래스
 *  - Entity class
 *  - DTO class Data Transfer Object
 *  
 *  - 1. 캡슐화 (private field + public method)
 *  - 2. field에 대해서 getter/setter메소드를 작성해둘것.
 *  - 3. 기본생성자/파라미터 생성자
 *
 */
public class Student {
	
	// field
	private String name;
	private char gender;
	private int age;
	
	// method : field 값을 활용해서 어떤 처리 절차를 작성
	public void printStudent() {
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
	}
	
	/**
	 * this 현재객체를 가리키는 메소드의 숨은 참조변수
	 */
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
}
