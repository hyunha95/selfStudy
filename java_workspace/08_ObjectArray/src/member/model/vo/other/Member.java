package member.model.vo.other;

import member.controller.Buyable;

/**
 * @실습문제 - 포인트관리시스템의 entity클라스의 상속관계만들기
회원등급을 추상화하여 Member클래스를 작성해 중복을 제거하세요.
* getEjaPoint메소드는 부모클래스에 정의한후, 각 회원별로 오버라이딩 할것
 *
 */

/* 
 * protected로 지정하면 자식 클래스에서 직접 접근 가능하다. 
 * Member의 자식클래스 Gold Silver Vip VVip에서는 직접 접근할 수 있다.
 * 
 * 단, 커스텀클래스를 상속하는 경우에는 protected 지정가능하지만, 
 * jdk가 제공하는 어떤 캡슐화된 클래스를 상속한다면, protected로 변경할 수 없다. 
 * -> super생성자를 통해 값세팅 & getter,setter 이용
 * 
 */

/**
 * 부모인터페이스/추상클래스의 추상메소드는 자식클래스에서 반드시 구현해야한다.
 *  - 단 자식클래스가 추상클래스(A)인 경우에는 이를 우회할 수 있다.
 *  - 해당 추상메소드는 A의 자식클래스에서 반드시 구현해야 한다.
 */
public abstract class Member implements Buyable{

	protected String name;
	protected String grade;
	protected int point;
	
	public Member() {

	}
	public Member(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return name + grade + point;
	}
	
	//추상메소드를 통한 메소드 구현을 강제화
	public abstract double getInterestPoint();
	
//	public double getInterestPoint() {
//		return point * 0;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
}
