/*
<객체실습>
클래스명 : com.oop.emp.model.Employee
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
Employee 클래스의 메소드 작성
1. 키보드입력용 메소드 : empInput()
2. emp객체 모든 필드 출력용 메소드 : empOutput()
3. getter/setter메소드
* 실행용 클래스 : com.oop.emp.run.EmpTest
메뉴작성 : 메소드 작성
=>메뉴 화면의 예
public void mainMenu(){}
******* 사원 정보 관리 프로그램 ************
	1. 새 사원 정보 입력  => empInput() 메소드 실행
	2. 사원 정보 삭제 => 사원객체 참조변수에 null대입할  것.
	3. 사원정보 출력 =>  empOutput() 메소드 실행
	9. 끝내기
********************************************

public void modifyMenu(Employee e){
	//setter 이용해서 키보드로 입력받은 값 객체 필드에 기록
}
********** 사원 정보 수정 메뉴 **********
	1. 이름 변경 => setEmpName()
	2. 급여 변경 => setSalary()
	3. 부서 변경 => setDept()
	4. 직급 변경 => setJob()
	5. 이전 메뉴로 이동 => return 처리할 것
********************************************
 */


// this 현재 메소드를 호출한 객체

package com.oop.emp.model;

import java.util.Scanner;

public class EmpTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		boolean flag = true;
		employee = null;
		EmpTest t = new EmpTest();
		while(flag) {
		t.mainMenu();
		int inputNum = sc.nextInt();
		
			switch(inputNum) {
			case 1: 
				employee.empInput();
				break;
			case 2:
				employee = null;
				break;
			case 3:
				if(employee == null) {
					System.out.println("사원정보부터 입력하세요.");
					break;
				}
				employee.empOutput();
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.print("다시 입력하세요 : ");
			}
		}
		t.modifyMenu(new Employee());
	}
	
	public void mainMenu() {
		System.out.println("********* 사원 정보 관리 프로그램 **********");
		System.out.println("1. 새 사원 정보 입력");
		System.out.println("2. 사원 정보 삭제");
		System.out.println("3. 사원정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("==> ");
	}
	
	public void modifyMenu(Employee e) {
		Employee employee = new Employee();
		boolean tOrF = true;
		outer:
		while(tOrF) {
			System.out.println("********* 사원 정보 수정 메뉴 **********");
			System.out.println("1. 이름 변경 ");
			System.out.println("2. 급여 변경 ");
			System.out.println("3. 부서 변경 ");
			System.out.println("4. 직급 변경 ");
			System.out.println("5. 이전 메뉴로 이동 ");
			System.out.print("====>");
			Scanner sc = new Scanner(System.in);
			int inputNum = sc.nextInt();
			
			switch(inputNum) {
			case 1:
				System.out.print("이름 입력 : ");
				employee.setEmpName(sc.next());
				break outer;
			case 2:
				System.out.print("급여 입력 : ");
				employee.setSalary(sc.nextInt());
				break outer;
			case 3:
				System.out.print("부서 입력 : ");
				employee.setDept(sc.next());
				break outer;
			case 4:
				System.out.print("직급");
				employee.setJob(sc.next());
				break outer;
			case 5:
				tOrF = false;
				return;
			default:
				System.out.println("1~5에서만 선택해주세요.");
				continue;
			}
			
		}
	}
}

