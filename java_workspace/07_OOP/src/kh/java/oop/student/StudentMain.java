package kh.java.oop.student;

/**
 * 
 * 이름		성별		나이
 * ----------------------
 * 김청수		남		20
 * 이영희		여		22
 * 
 * 객체는 new연산자 호출을 통해 class의 설계대로 데이터를 메모리에 할당한 결과물.
 * 		데이터를 처리할 수 있다.
 *
 */
public class StudentMain {

	public static void main(String[] args) {
		Student stdt1 = new Student();
		
		// field에 값대입
//		stdt1.name = "김철수";
//		stdt1.gender = '남';
//		stdt1.age = 20;
		stdt1.setName("김철수");
		stdt1.setGender('남');
		stdt1.setAge(20);
		
		System.out.println("이름 : " + stdt1.getName());
		System.out.println("성별 : " + stdt1.getName());
		System.out.println("나이 : " + stdt1.getAge());
		// method호출
		stdt1.printStudent();
		
		Student stdt2 = new Student();
//		stdt2.name = "이영희";
//		stdt2.gender = '여';
//		stdt2.age = 22;
		stdt2.setName("이영희");
		stdt2.setGender('여');
		stdt2.setAge(22);
		
		stdt2.printStudent();

	}

}
