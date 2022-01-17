package com.kh.member.run;

import com.kh.member.view.MemberMenu;

/*
 * MVC Pattern
 * 
 * Model 
 * View 사용자가 보게될 화면, 메뉴, 사용자 입력값처리, db조회결과
 * Controller 앱흐름제어
 * 
 */
public class Run {

	public static void main(String[] args) {
		new MemberMenu().mainMenu();
		System.out.println("===== 이용해 주셔서 감사합니다. =====");
	}

}
