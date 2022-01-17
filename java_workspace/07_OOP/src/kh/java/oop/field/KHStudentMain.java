package kh.java.oop.field;

/**
 * 우리반 학생정보 관리
 * M강의장
 */

public class KHStudentMain {

	public static void main(String[] args) {
		//KHStudent객체1 값대입후 출력
		KHStudent k = new KHStudent();
		k.setStudentName("둘리");
		k.setNumber("01012341234");
		k.printKHStudnetInfo();

		//KHStudent객체2 값대입후 출력
		KHStudent k1 = new KHStudent();
		k1.setStudentName("고길동");
		k1.setNumber("01011223344");
		k1.printKHStudnetInfo();
	}

}
