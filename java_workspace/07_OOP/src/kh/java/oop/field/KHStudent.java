package kh.java.oop.field;

/**
 * kh정보교육원 학생정보
 * - 교육원명
 * - 과정명
 * - 학생명
 * - 강의장명
 * - 전화번호
 * 
 * + printKHStudnetInfo():void 모든 필드정보를 출력
 *
 */
public class KHStudent {
	
	//클래스변수
	public static final String ACADEMY_NAME = "kh정보교육원";
	public static final String COURSE_NAME = "스마트컨텐츠와 웹융합 응용SW개발자과정";
	public static final char CLASSROOM = 'M';
	
	//인스턴스(멤버)변수
	private String name;
	private String number;

	
	public void setStudentName(String name) {
		this.name = name;
	}
	public String getStudentName() {
		return name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	
	public void printKHStudnetInfo() {
		System.out.println("교육원명 : " + ACADEMY_NAME);
		System.out.println("과정명 : " + COURSE_NAME);
		System.out.println("강의장명 : " + CLASSROOM);
		System.out.println("학생명 : " + name);
		System.out.println("전화번호 : " + number);
	}

}
