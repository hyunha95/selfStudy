package com.exception.charcheck;

/**
 * <문제 1>
 - 패키지명 : com.exception.charcheck
 1. 사용자 정의 예외클래스 만들기
	클래스명 : CharCheckException
 2. 클래스 만들기
	클래스명 : CharacterProcess
	기본 생성자
	메소드
	//전달된 문자열값에서 영문자가 몇개인지 카운트해서 리턴
	public int countAlpha(String s){}
	//단, 공백문자가 있으면, CharCheckException 발생
 3. 실행용 클래스 : Run (main 포함)
	실행할 메소드 작성 : public void test1(){}
	키보드로 문자열을 입력받아 사용
	countAlpha 메소드로 문자열 전달하고, 실행결과 받아 출력함.
	- 반드시 try ~ catch 문 사용.
	에러메시지 : "체크할 문자열 안에 공백 포함할 수 없습니다."
 */

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Run run = new Run();
		run.test1();

	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		CharacterProcess cp = new CharacterProcess();
		
		while(true) {
			try {
				System.out.println("개수를 확인할 문자열을 입력하세요 (공백금지)!!");
				System.out.print("=>");
				String str = sc.nextLine();
				System.out.println("입력한 [" + str + "]에 영문자가 " + cp.countAlpha(str) + "개 입니다.");
				
			} catch(CharCheckException e) {
				System.err.println("체크할 문자열 안에 공백 포함할 수 없습니다.");
				continue;
			} 
			break;
		}
	}

}













