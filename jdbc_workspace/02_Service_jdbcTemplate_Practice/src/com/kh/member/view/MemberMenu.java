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
				+ "7. 탈퇴 회원 조회\n"
				+ "0. 프로그램 종료\n"
				+ "**************************\n"
				+ "선택 : ";
		while(true) {
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();

			switch(choice) {
			case "1" : 
				printMemberList(memberController.selectAllMember());
				break;
			case "2" : 
				printMember(memberController.selectOneMember(inputMemberId()));
				break;
			case "3" : 
				printMemberList(memberController.selectMemberByName(InputName()));
				break;
			case "4" : 
				System.out.println(memberController.insertMember(inputMember()) > 0 ? "> 회원 가입 성공!" : "> 회원 가입 실패!");
				break;
			case "5" : 
				updateMenu();
				break;
			case "6" : 
				System.out.println(memberController.deleteMember(inputMemberId()) > 0 ? "> 회원 탈퇴 성공!" : "> 회원탈퇴 실패!");
				break;
			case "7" :
				printMemberList(memberController.selectAllMemberDel());
				break;
			case "0" : return;
			default : System.out.println("잘못 입력했습니다."); break;
			}
		}
		
	}
	
	private void updateMenu() {
		String menu = "----------- 회원 정보 수정 -----------\n"
				+ "1. 이름 변경\n"
				+ "2. 이메일 변경\n"
				+ "3. 주소 변경\n"
				+ "0. 메인메뉴로 돌아가기\n"
				+ "-----------------------------------\n"
				+ "선택 : ";
		
		String id = inputMemberId();
		
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
			String colName = null;
			String newValue = null;
			
			switch(choice) {
			case "1" : 
				System.out.print("변경할 이름 : ");
				colName = "name";
				newValue = sc.next();
				break;
			case "2" : 
				System.out.print("변경할 이메일 : ");
				colName = "email";
				newValue = sc.next();
				break;
			case "3" : 
				System.out.print("변경할 주소 : ");
				colName = "address";
				sc.next();
				newValue = sc.nextLine();
				break;
			case "0" : return;
			default : System.out.println("잘못 입력하셨습니다."); continue;
			
			}
		int result = memberController.updateMember(id, colName, newValue);
		System.out.println(result > 0 ? "> 회원정보 수정 성공!" : "> 회원정보 수정 실패!");
		}
		
		
	}

	private Member inputMember() {
		String id = checkIdDuplicate();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("성별 : ");
		String gender = String.valueOf(sc.next().toUpperCase().charAt(0));
		
		// 사용자 입력값 -> java.util.Calendar -> java.sql.Date
		System.out.print("생년월일(예 : 19900909) : ");
		String temp = sc.next();
		int year = Integer.parseInt(temp.substring(0, 4));
		int month = Integer.parseInt(temp.substring(4, 6));
		int date = Integer.parseInt(temp.substring(6, 8));
		Calendar cal = new GregorianCalendar(year, month, date);
		Date birthday = new Date(cal.getTimeInMillis());
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		Member member = new Member(id, name, gender, birthday, email, address, null);
		
		return member;
		
	}

	private String checkIdDuplicate() {
		String id = null;
		do {
			if(id != null)
				System.out.printf("> [%s]는 이미 사용중입니다.%n", id);
			System.out.print("아이디 : ");
			id = sc.next();
		} while(memberController.selectOneMember(id) != null);
		return	id;
	}

	private String InputName() {
		System.out.print("검색할 이름 : ");
		return sc.next();
	}

	private String inputMemberId() {
		System.out.print("회원 아이디 입력 : ");
		return sc.next();
	}

	private void printMember(Member member) {
		if(member == null) {
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			System.out.println("--------------------------------");
			System.out.println("아이디 : " + member.getId());
			System.out.println("이름 : " + member.getName());
			System.out.println("성별 : " + ("M".equals(member.getGender()) ? "남" : "여"));
			System.out.println("생일 : " + member.getBirthday());
			System.out.println("이메일 : " + member.getEmail());
			System.out.println("주소 : " + member.getAddress());
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
			System.out.println("등록일 : " + sdf.format(member.getRegDate()));
			System.out.println("--------------------------------");
		}
		
	}

	private void printMemberList(List<Member> list) {
		if(list.isEmpty()) {
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-10s%n", 
							  "id", "name", "gender", "birthday", "email", "address", "regDate");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for(Member m : list) {
			System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-10s%n", 
						m.getId(), m.getName(), "M".equals(m.getGender()) ? "남" : "여", m.getBirthday(),
						m.getEmail(), m.getAddress(), m.getRegDate());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		}
		
	}

}
