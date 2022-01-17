package member.view;

import java.util.Scanner;

import member.controller.MemberManager;
import member.model.vo.Member;

/**
 * 
 * MemberRun : 프로그램 시작. 실행클래스
 * MemberMenu : 사용자가 보게될 메뉴, 조회결과, 사용자입력 환경을 제공하는 클래스
 * Member : 데이터를 저장/전달할 클래스
 * MemberManager : 내부적으로 기능수행. 회원관리, 데이터입출력
 *
 *
 */
public class MemberMenu {
	
	Scanner sc = new Scanner(System.in);
	MemberManager manager = new MemberManager();

	public void mainMenu() {
		String menu = "\n===== 회원관리 =====\n"
					+ "1. 회원조회\n"
					+ "2. 회원추가\n"
					+ "0. 프로그램 종료\n"
					+ "------------------\n"
					+ "선택 : ";
		
		while(true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				Member[] members = manager.selectAllMember();
				displayMembers(members);
				break;
			case 2: 
				Member member = inputMember();
				boolean result = manager.insertMember(member);
				System.out.println(result ? "> 회원 추가 성공!" : "> 회원 추가 실패!");
				break;
			case 0: return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		
		
	}

	/**
	 * 사용자 입력 회원정보를 Member객체로 생성, 리턴하는 메소드
	 */
	private Member inputMember() {
		System.out.println("> 새 회원정보를 입력해주세요.");
		System.out.print("id : ");
		String userId = sc.next();
		System.out.print("password : ");
		String userPwd = sc.next();
		System.out.print("name : ");
		String userName = sc.next();
		
		return new Member(userId, userPwd, userName);
	}

	/**
	 * 회원 목록 출력 메소드
	 *
	 */
	private void displayMembers(Member[] members) {
		
		if(members != null) {
			System.out.println("> 조회된 회원은 다음과 같습니다.");
			System.out.println("____________________________________________");
			for(int i = 0; i < members.length; i++) {
				if(members[i] == null)
					break;
				System.out.println(members[i]);
			}
			System.out.println("____________________________________________");
		} 
		else {
			System.out.println("> 조회된 회원 목록이 없습니다.");
		}

	}
}
