package com.kh.member.view;

import java.sql.Date;
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
					+ "1. 회원 전체 조회\n"
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
			
			switch(choice) {
			case "1" : 
				list = memberController.selectAllMember();
				printMemberList(list);
				break;
			case "2" : break;
			case "3" : break;
			case "4" : 
				member = inputMember();
				result = memberController.insertMember(member);
				System.out.println(result > 0 ? "> 회원 가입 성공 !" : "> 회원 가입 실패!");
				break;
			case "5" : break;
			case "6" : 
				id = inputId("삭제할 아이디 입력 : ");
				result = memberController.deleteMember(id);
				System.out.println(result > 0 ? "> 회원 삭제 성공 !" : "> 회원 삭제 실패!");				
				break;
			case "0" : return;
			default : System.out.println("> 잘못입력하셨습니다.");
			}
		}
		
		
		
				
	}

	private String inputId(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	private Member inputMember() {
		System.out.println("> 새 회원정보를 입력하세요.");
		
		System.out.println("아이디 : ");
		String id = sc.next();
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("성별(M/F) : ");
		String gender = String.valueOf(sc.next().toUpperCase().charAt(0));
		
		System.out.println("생년월일(예:19900909) : ");
		String temp = sc.next();
		int year = Integer.parseInt(temp.substring(0, 4));
		int month = Integer.parseInt(temp.substring(4, 6));
		int date = Integer.parseInt(temp.substring(6));
		Calendar cal = new GregorianCalendar(year, month, date);
		Date birthday = new Date(cal.getTimeInMillis());
		
		System.out.println("이메일 : ");
		String email = sc.next();
		
		sc.nextLine();
		System.out.println("주소: ");
		String address = sc.nextLine();
		
		return new Member(id, name, gender, birthday, email, address, null);
	}

}


















