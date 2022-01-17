package kh.java.oop.field;

/**
 * 변수
 * 1. 지역변수 local variable : 메소드안에 선언된 변수, 매개변수도 포함
 * 
 * 2. 전역변수 global variable: 메소드 밖에 선언된 변수
 * 		- static변수(클래스변수) : 클래스마다 생성되는 변수. 한번만 만들어져 공유함. static 영역에 만들어진다.
 * 			-> static변수는 클래스 이름으로 접근한다.
 * 		- non-static변수(인스턴스변수, 멤버변수) : 객체마다 생성되는 변수
 * 
 * 생명주기 Life Cycle
 * 1. 지역변수 : 메소드호출 ~ 메소드종료
 * 2. 멤버변수 : 객체생성시 ~ 객체삭제시(객체연결이 끊어진 경우) -> garbage collector에 의해 반환시
 * 3. 클래스변수 : 프로그램시작시(클래스를 처음 사용시) ~ 프로그램 종료시
 * 		- 동적로딩(Dynamic Loading) : 프로그램 시작 이후 실제 사용시 메모리 적재되는 것. 프로그램 효율성이 좋아진다.
 *
 */
public class IPhone12 {
	
	// 상수명은 모두 대문자로 처리한다. 여러 단어인 경우에는 _로 연결한다.
	public static final int WIDTH = 10;
	public static final int HEIGHT = 20;
	private String name;	// 소유주 이름
	private String tel; 	// 전화번호
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	
	/**
	 * 지역변수
	 * 1. String to
	 * 2. String str
	 * 
	 * 현재메소드 안에서만 사용가능하다.
	 */
	public void call(String to) {
		String str = name + "이/가 " + to + "로 전화를 겁니다.";
		System.out.println(str);
	}
}




