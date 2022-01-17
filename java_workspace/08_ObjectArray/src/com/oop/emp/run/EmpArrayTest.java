/*
<객체실습>
클래스명 : com.oop.emp.model.dto.Employee
	- 사원정보 관리용 클래스
- Field 작성 : 캡슐화 반드시 적용함
	사번 : - empNo:int
	이름 : - empName:String
	소속부서 : - dept:String
	직급 : - job:String
	나이 : - age:int
	성별 : - gender:char
	급여 : - salary:int
	보너스포인트 : - bonusPoint:double
	핸드폰 : - phone:String
	주소 : - address:String
- 메소드 작성
 1. 디폴트 생성자와 매개변수 있는 생성자 추가함
	매개변수 있는 생성자 2개 작성함
	* 사번, 이름, 나이, 성별, 핸드폰, 주소 초기화 생성자
	* 모든 필드를 초기화하는 생성자
 2. 각 필드에 대한 Setter & Getter 메소드 추가함
 3, 모든 필드값을 하나의 문장(문자열합치기)으로 만들어 리턴하는 메소드 추가함
	public String empInformation()
* control 클래스 : com.oop.emp.controller.EmployeeManager
	1. control클래스 생성시 3명의 사원정보를 담을 수 있는 객체배열 eArr 생성함.
	2. eArr의 각 요소 Employee의 정보를 출력할 수 있는 메소드 printEmployees:void
	3. eArr의 각 요소 Employee의 연봉정보를 계산해 출력하는 메소드 printAnnualSalary:void
		연봉 = (급여 + (급여 * 보너스포인트)) * 12 ;
	4. 3직원의 연봉평균 출력메소드 printAnnualSalaryAvg:void
* 실행용 클래스 : com.oop.emp.run.EmpArrayTest : main() 메소드 포함
	1. 3개의 생성자를 각각 호출해 생성한 3개의 Employee객체를 배열요소로 추가함
	2. control클래스의  printemployees메소드를 사용하여, 사원정보출력
	3. 3개의 객체중 값이 없는 필드에 각각 값을 입력해 넣음. setter 이용할 것
	4. 직원별 각각의 보너스가 적용된 1년 연봉 출력
	5. 모든직원의 1년 연봉의 평균을 구하여 출력함
<출력 결과>
ear[0] : 0, null, null, null, 0, □, 0, 0.0, null, null
ear[1] : 201503, 박길동, null, null, 29, M, 0, 0.0, 010-1234-5678, 경기도 의정부시
ear[2] : 201004, 김철수, 개발부, 과장, 34, M, 4500000, 0.15, 010-2143-9876, 서울시 노원구 노원동 123
-------------------------------------------------------
ear[0] : 201305, 이영희, 총무부, 대리, 28, F, 3750000, 0.1, 010-9512-7534, 경기도 동두천
ear[1] : 201503, 박길동, 기획부, 사원, 29, M, 2900000, 0.05, 010-1234-5678, 경기도 의정부시
-------------------------------------------------------
이영희의 연봉 : 49500000
박길동의 연봉 : 36540000
김철수의 연봉 : 62100000
-------------------------------------------------------
직원들의 연봉의 평균 : 49380000
 */

package com.oop.emp.run;

import com.oop.emp.controller.EmployManager;
import com.oop.emp.model.dto.Employee;

public class EmpArrayTest {

	public static void main(String[] args) {
		EmployManager em = new EmployManager();
		//1. 3개의 생성자를 각각 호출해 생성한 3대의 Employee객체를 배열요소로 추가함
		Employee emp = new Employee();
		em.eArr[0] = emp;
		Employee emp1 = new Employee(201503, "박길동", 29, 'M', "010-1234-5678", "경기도 의정부시");
		em.eArr[1] = emp1;
		Employee emp2 = new Employee(201004, "김철수", "개발부", "과장", 34, 'M', 4500000, 0.15, "010-2143-9876", 
										"서울시 노원구 노원동 123");
		em.eArr[2] = emp2;
		//2. control클래스의 printemployees메소드를 사용하여, 사원정보 출력
		em.printEmployees(em.eArr.length);
		System.out.println("----------------------------------------------------------------");
		
		//3. 3개의 객체중 값이 없는 필드에 각각 값을 입력해 넣음. setter 이용할 것.
		// 이영희 정보
		emp.setEmpNo(201503);
		emp.setEmpName("이영희");
		emp.setDept("총무부");
		emp.setJob("대리");
		emp.setAge(28);
		emp.setGender('F');
		emp.setSalary(3750000);
		emp.setBonusPoint(0.1);
		emp.setPhone("010-9512-7534");
		emp.setAddress("경기도 동두천");
		em.eArr[0] = emp;
		
		//박길동 정보
		emp1.setDept("기획부");
		emp1.setJob("사원");
		emp1.setSalary(2900000);
		emp1.setBonusPoint(0.05);
		emp1.setPhone("010-1234-5678");
		emp1.setAddress("경기도 의정부시");
		em.eArr[1] = emp1;
		em.printEmployees(2);
		System.out.println("----------------------------------------------------------------");
		
		//4. 직원별 각각의 보너스가 적용된 1년 연봉 출력
		em.printAnnualSalary();
		System.out.println("----------------------------------------------------------------");
		//5. 모든직원의 1년 연봉의 평균을 구하여 출력함
		em.printAnnualSalaryAvg();
	}

}
