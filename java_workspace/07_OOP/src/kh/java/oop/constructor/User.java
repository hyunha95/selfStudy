package kh.java.oop.constructor;

import java.util.Date;

/**
 * 
 * VO 클래스(Value Object)
 * DTO
 * Entity
 * Domain
 *
 * 1. 캡슐화
 * 2. 기본생성자/파라미터생성자
 * 3. getter/setter
 * 
 * 생성자 constructor 
 * - new 연산자에 의해 호출되는 메소드
 * - 객체생성시, 객체필드에 대한 초기화를 담당한다.
 * - 클래스이름과 동일해야 한다.
 * - 리턴타입을 가질 수 없다.
 * - 파라미터생성자를 작성하지 않는 한, JVM은 기본생성자를 자동으로 생성해준다.
 * - 파라미터생성자를 작성하면, 명시적으로 기본생성자를 생성해야 한다.
 * 
 * User user = new User();
 * 
 * 기본생성자는 반드시 필요하다.
 * - 상속구조에서 자식객체 생성시 부모클래스의 기본생성자를 호출!
 * - SpringFramework에서 DI할때 기본생성자를 호출!
 * 
 * 다른생성자호출 : this()
 * - 생성자 맨 첫출에 한번만 호출이 가능
 * - User() (x) -> this() (o)
 * 
 */
public class User {

	private String id;
	private String password;
	private Date regDate;
	
	/**
	 * 기본생성자 : 매개변수 없음
	 */
	public User() {
		
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
//		this.regDate = new Date();
	}
	
	/**
	 * 파라미터 생성자
	 */
	public User(String id, String password, Date regDate) {
		this(id, password);
//		this.id = id;
//		this.password = password;
		this.regDate = regDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	
	public void printUser() {
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("regDate : " + regDate);
		
	}
}






