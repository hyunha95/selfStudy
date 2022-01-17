package com.kh.member.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberDel;

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
			case "1" : printMemberList(memberController.selectAllMember()); break;
			case "2" : printMember(memberController.selectOneMember(inputMemberId())); break;
			case "3" : printMemberList(memberController.selectMemberByName(inputName())); break;
			case "4" : System.out.println(memberController.insertMember(inputMember()) > 0 ? "회원가입 성공!" : "회원가입실패!"); break;
			case "5" : updateMenu(); break;
			case "6" : System.out.println(memberController.deleteMember(inputMemberId()) > 0 ? "> 회원탈퇴 성공!" : "> 회원탈퇴 실패!"); break;
			case "7" : 
				// del_date컬럼값도 함께 출력할 것.
				printMemberDelList(memberController.selectAllMemberDel());
				break;
			case "0" : return;
			default : 
				System.out.println("잘못 입력했습니다.");
				break;
			}
		}
	}
	/**
	 * 회원정보 수정 메뉴 
	 * 1. 수정메뉴 보이기전에 입력한 사용자 id에 해당하는 정보를 조회/출력
	 * 		- 조회된 회원이 없다면 메인메뉴로 돌아갈것
	 * 2. 선택한 메뉴에 해당하는 컬럼을 수정처리
	 * 3. 다시 수정메뉴가 보이기전에 해당 회원 정보 출력
	 */
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
				sc.nextLine(); // 개행날리기용
				newValue = sc.nextLine();
				break;
			case "0" : return;
			default : 
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
			int result = memberController.updateMember(id, colName, newValue);
			System.out.println(result > 0 ? "> 회원정보 수정 성공!" : "> 회원정보 수정 실패!");
			
		}
		
	}
	
	private String inputMemberId() {
		System.out.print("회원아이디 입력 : ");
		return sc.next();
	}

	/**
	 * 조회된 1행의 회원정보 출력 메소드
	 * @param member
	 */
	private void printMember(Member member) {
		if(member == null) {
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			System.out.println("-------------------------------");
			System.out.println("아이디 : " + member.getId());
			System.out.println("이름 : " + member.getName());
			System.out.println("성별 : " + ("M".equals(member.getGender()) ? "남" : "여"));
			System.out.println("생일 : " + member.getBirthday());
			System.out.println("이메일 : " + member.getEmail());
			System.out.println("주소 : " + member.getAddress());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			System.out.println("등록일 : " + sdf.format(member.getRegDate()));
			System.out.println("-------------------------------");
		}
	}
	
	/**
	 * 조회된 n행의 회원정보를 출력메소드
	 * @param list
	 */
	private void printMemberList(List<Member> list) {
		if(list == null || list.isEmpty()) {
			// 조회된 행이 없는 경우
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			// 조회된 행이 있는 경우
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-10s %-10s %-10s%n", 
							  "id", "name", "gender", "birthday", "email", "address", "regDate", "delDate", "delFlag");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			
			for(Member m : list) {
				System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-10s %-10s %-10s%n", 
								  m.getId(), 
								  m.getName(), 
								  "M".equals(m.getGender()) ? "남" : "여", 
								  m.getBirthday(), 
								  m.getEmail(), 
								  m.getAddress(), 
								  new SimpleDateFormat("yy-MM-dd HH:mm").format(m.getRegDate()));
			}
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * 조회된 n행의 탈퇴회원정보를 출력메소드
	 * @param list
	 */
	private void printMemberDelList(List<MemberDel> list) {
		if(list.isEmpty()) {
			// 조회된 행이 없는 경우
			System.out.println("> 조회된 행이 없습니다.");
		}
		else {
			// 조회된 행이 있는 경우
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-20s %-20s %n", 
							  "id", "name", "gender", "birthday", "email", "address", "regDate", "delDate");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			
			for(MemberDel m : list) {
				System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s %-20s %-20s%n", 
								  m.getId(), 
								  m.getName(), 
								  "M".equals(m.getGender()) ? "남" : "여", 
								  m.getBirthday(), 
								  m.getEmail(), 
								  m.getAddress(), 
								  new SimpleDateFormat("yy-MM-dd HH:mm").format(m.getRegDate()),
								  new SimpleDateFormat("yy-MM-dd HH:mm").format(m.getDelDate()));
			}
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		}
	}
	

	private String inputName() {
		System.out.print("검색할 이름 : ");
		return sc.next();
	}

	/**
	 * 사용자 입력 정보를 Member객체로 반환
	 * @return
	 */
	private Member inputMember() {
		System.out.println("> 새 회원정보를 입력하세요.");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		
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

}
