package com.kh.member.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	
	public void mainMenu() {
		String menu = "***** 회원 관리 프로그램 *****\n"
					+ "1. 전체 조회\n"
					+ "2. 아이디 조회\n"
					+ "3. 이름 검색\n"
					+ "4. 회원 가입\n"
					+ "5. 회원 정보 변경\n"
					+ "6. 회원 탈퇴\n"
					+ "0. 프로그램 종료\n"
					+ "**************************\n"
					+ "선택 : ";
		
		while(true) {
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();
			
			Member member = null;
			int result = 0;
			String id = null;
			List<Member> list = null;
			String name = null;
			
			switch(choice) {
			case "1": 
				list = memberController.selectAllMember();
				printMemberList(list);
				break;
			case "2": 
				id = inputId("조회할 아이디 : ");
				member = memberController.selectOneMember(id);
				printMember(member);
				break;
			case "3": 
				//@실습문제 : 이름검색
				//이름 일부만 입력해도 조회가 가능해야 한다.
				name = inputMemberName();
				list = memberController.selectMemberByName(name);
				printMemberList(list);
				break;
			case "4":
				//@실습문제 : 회원가입시 아이디 중복이 되지 않도록 미리 검사할 것. 
				member = inputMember(); 
				System.out.println("member@menu = " + member);
				result = memberController.insertMember(member); // 모든 dml요청은 정수값이 반환
				System.out.println(result > 0 ? "> 회원 가입 성공!" : "> 회원 가입 실패!");
				break;
			case "5": 
				//@실습문제 : 수정
				//별도의 수정 서브메뉴를 통해 이름, 이메일, 주소를 변경
				//단 수정메뉴 진입시 변경할 아이디 조회후 조회된 회원이 있을경우만 수정메뉴를 출력
				//수정메뉴 출력전에 해당회원의 정보를 1회 출력
				updateMenu();
				break;
			case "6": 
				id = inputId("삭제할 아이디 입력 : ");
				result = memberController.deleteMember(id);
				System.out.println(result > 0 ? "> 회원 삭제 성공!" : "> 회원 삭제 실패!");
				break;
			case "0": return;
			default: System.out.println("> 잘못 입력하셨습니다.");
			}
		}
		
	}
	
    /**
	 * 검색할 이름 입력
	 * @return
	 */
	private String inputMemberName() {
		System.out.print("조회할 회원 이름 입력 : ");
		return sc.next();
	}


	private void updateMenu() {
		String menu = "----------- 회원 정보 수정 -----------\n"
				+ "1. 이름 변경\n"
				+ "2. 이메일 변경\n"
				+ "3. 주소 변경\n"
				+ "0. 메인메뉴로 돌아가기\n"
				+ "-----------------------------------\n"
				+ "선택 : ";
		
		String id = inputId("수정할 아이디 : ");
		
		while(true) {
			Member member = memberController.selectOneMember(id);
			if(member == null) {
				System.out.println("> 조회된 회원이 없습니다.");
				return;
			}
			else {
				printMember(member);
			}
			
			System.out.print(menu);
			String choice = sc.next();
			int result = 0;
			
			switch(choice) {
			case "1" : 
				System.out.print("변경할 이름 : ");
				String newName = sc.next();
				result = memberController.updateMemberName(id, newName);
				System.out.println(result > 0 ? "> 회원명 변경 성공!" : "> 회원명 변경 실패!");
				break;
			case "2" : 
				System.out.print("변경할 이메일 : ");
				String newEmail = sc.next();
				result = memberController.updateMemberEmail(id, newEmail);
				System.out.println(result > 0 ? "> 이메일 변경 성공!" : "> 이메일 변경 실패!");
				break;
			case "3" : 
				System.out.print("변경할 주소 : ");
				sc.nextLine();
				String newAddress = sc.nextLine();
				result = memberController.updateMemberAddress(id, newAddress);
				System.out.println(result > 0 ? "> 주소 변경 성공!" : "> 주소 변경 실패!");
				break;
			case "0" : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}




	/**
	 * 회원객체 하나를 출력하는 메소드
	 * @param member
	 */
	private void printMember(Member member) {
		if(member == null) {
			System.out.println("> 해당하는 회원이 없습니다.");
		}
		else {
			System.out.println("--------------------------------------");
			System.out.println("아이디 : " + member.getId());
			System.out.println("이름 : " + member.getName());
			System.out.println("성별 : " + member.getGender());
			System.out.println("생일 : " + member.getBirthday());
			System.out.println("이메일 : " + member.getEmail());
			System.out.println("주소 : " + member.getAddress());
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
			System.out.println("등록일 : " + sdf.format(member.getRegDate()));
			System.out.println("--------------------------------------");
		}
	}

	/**
	 * 복수개의 Member객체를 출력하는 메소드
	 * @param list
	 */
	private void printMemberList(List<Member> list) {
		if(list.isEmpty()) {
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("id	name	gender	birthday	email				address				reg_date");
			System.out.println("--------------------------------------------------------------------------------------------");
			for(Member member : list) {
				System.out.println(member);
			}
			System.out.println("--------------------------------------------------------------------------------------------");
		}
	}

	/**
	 * 사용자 입력한 아이디를 리턴
	 * @param msg
	 * @return
	 */
	private String inputId(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	/**
	 * 사용자 입력 정보를 Member객체로 반환
	 * @return
	 */
	private Member inputMember() {
		System.out.println("> 새 회원정보를 입력하세요.");
		
		
		String id = checkIdDuplicate();
		
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("성별(M/F) : ");
		String gender = String.valueOf(sc.next().toUpperCase().charAt(0));
		
		// 사용자 입력값 -> java.util.Calendar -> java.sql.Date
		System.out.print("생년월일(예: 19900909) : ");
		String temp = sc.next();
		int year = Integer.valueOf(temp.substring(0, 4));
		int month = Integer.valueOf(temp.substring(4, 6)) - 1; // 0 ~ 11월
		int date = Integer.valueOf(temp.substring(6, 8));
		Calendar cal = new GregorianCalendar(year, month, date);
		Date birthday = new Date(cal.getTimeInMillis()); 
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		sc.nextLine(); // 버퍼에 남은 개행문자 제거!
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		return new Member(id, name, gender, birthday, email, address, null);
	}

	private String checkIdDuplicate() {
		String id = null;
		do {
			if(id != null)
				System.out.printf("> [%s]는 이미 사용중입니다.%n", id);
			System.out.print("아이디 : ");
			id = sc.next();
		} while(memberController.selectOneMember(id) != null);
		return id;
	}
	
}
