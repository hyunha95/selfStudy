package kh.java.collection.map.student;
/*
 * @실습문제 : properties 학생 점수관리
@실습문제2
 - score.txt로 부터 내용을 읽어와서 처리할 것.

 - Student 클래스 작성 : com.collection.map.student.Student.java
	//Field
	- int sno;
	- String sname;
	- int kor, eng, math, sum;
	- double avg;
	//생성자, 파라미터생성자(sno, sname, kor, eng, math)를 입력받고, sum, avg는 계산해서 초기화
		avg는 소수점둘째자리에서 반올림처리.
	//getter, setter, toString() 오버라이딩 처리

 - 테스트 클래스 : com.collection.map.student.StudentProperties.java
	main() 포함
 - 메소드 추가 : public List<Student> readFile(){}
	//구현 내용
	1. Properties 객체 생성하고, score.txt 파일의 내용을 읽어
	2. 리스트 만듦
	3. 키를 사용하여, 객체정보를 List<Student>에 저장하여 리턴함
	  => ", " 으로 문자열 분리처리
	  => 분리된 문자열을 각 자료형 필드의 값으로 형변환 대입 저장함

 - 메소드 추가 : public void printConsole(List<Student> stdtList){}
	1. 전달받은 값 출력
	2. 각 객체의 국어합계, 영어합계, 수학합계를 구하고
	3. 과목별 평균점수를 출력함
 - 메소드 추가 : public void saveXMLFile(List<Student> stdtList){}
	1. "student.xml" 파일에 번호필드를 key로 객체가 가진 값 기록 저장함.
 */
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class StudentProperties {

	public static void main(String[] args) {
		StudentProperties main = new StudentProperties();
		List<Student> list = main.readFile();
		main.printConsole(list);
		main.saveXmlFile(list);

	}
	
	/**
	 * xml데이터 추출
	 * 
	 * List<Student> -> Student별 key, value -> prop에 속성저장(setProperty) -> xml생성
	 * 
	 */
	public void saveXmlFile(List<Student> list) {
		Properties prop = new Properties();
		for(Student s : list) {
			String key = String.valueOf(s.getSno());
			String value = s.getSno() + ", "
						  +s.getName() + ", "
						  +s.getKor() + ", "
						  +s.getEng() + ", "
						  +s.getMath();
			prop.setProperty(key, value);
		}
//		System.out.println(prop);
		
		// xml로 저장
		try {
			prop.storeToXML(new FileOutputStream("score.xml"), "score.xml");
			System.out.println("xml 파일 저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 전달받은 list의 학생정보를 이용해서 국영수합계
	 * 국어합계/영어합계/수학합계 조회
	 * 국어평균/영어평균/수학평균 조회 및 출력
	 */
	public void printConsole(List<Student> list) {
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for(Student s : list) {
			System.out.println(s);
			korSum += s.getKor();
			engSum += s.getEng();
			mathSum += s.getMath();
		}
		System.out.printf("국어점수의 합계 = %d, 국어점수평균 = %.1f%n", korSum, (double)korSum / list.size());
		System.out.printf("영어점수의 합계 = %d, 영어점수평균 = %.1f%n", engSum, (double)engSum / list.size());
		System.out.printf("수학점수의 합계 = %d, 수학점수평균 = %.1f%n", mathSum, (double)mathSum / list.size());
	}
	
	/**
	 * 1. score.txt를 읽어서 Properties객체생성
	 * 2. 학생번호, 이름, 국, 영, 수 -> Student -> List에 추가
	 * 3. List리턴 
	 */
	public List<Student> readFile(){
		Properties prop = new Properties();
		List<Student> list = new ArrayList<>();
		try {
			prop.load(new FileReader("Student/score.txt"));
			//score.txt읽을때 properties가 자동으로 =을 기준으로 키와값을 분리한다.
			Set<String> keySet = prop.stringPropertyNames();
			for(String key : keySet) {
				// 1. csv 데이터 처리
				String v = prop.getProperty(key);
				String[] temp = v.split(",");
				
				// 2. 필드정보 추출 및 형변환
				int sno = Integer.valueOf(temp[0]);
				String name = temp[1];
				int kor = Integer.valueOf(temp[2]);
				int eng = Integer.valueOf(temp[3]);
				int math = Integer.valueOf(temp[4]);
				
				// 3. Student객체 생성 및 list추가
				Student stdt = new Student(sno, name, kor, eng, math);
				list.add(stdt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
