package member.run;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import member.model.vo.Member;
import member.view.MemberMenu;

/**
 * 
 * MemberRun : 프로그램 시작. 실행클래스
 * MemberMenu : 사용자가 보게될 메뉴, 조회결과, 사용자입력 환경을 제공하는 클래스
 * Member : 데이터를 저장/전달할 클래스
 * MemberManager : 내부적으로 기능수행. 회원관리, 데이터입출력
 *
 */
public class MemberRun {

	public static void main(String[] args) {
		MemberRun run = new MemberRun();
		run.test();
		
		//프로그램 시작
		MemberMenu memberMenu = new MemberMenu();
		memberMenu.mainMenu();
		
		
		System.out.println("------ 프로그램 종료 ------");

	}

	/**
	 * member.ser 읽어오기
	 */
	public void test() {
		File src = new File("member.ser");
		try(
			ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
		) {
			Member[] members = (Member[]) ois.readObject();
			
			System.out.println(members.length);
			
			for(int i = 0; i < members.length; i++)
				System.out.println(members[i]);
			
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
