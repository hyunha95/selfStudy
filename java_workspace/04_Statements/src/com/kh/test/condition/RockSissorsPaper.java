package com.kh.test.condition;

import java.util.Scanner;

public class RockSissorsPaper {

	public static void main(String[] args) {
		RockSissorsPaper rsp = new RockSissorsPaper();
		rsp.game();
		System.out.println("프로그램 종료");
	}
	
	public void game() {
		System.out.println("=== 가위 바위 보 게임 ===");
		// 컴퓨터
		int computer = (int)(Math.random() * 3) + 1; // 1 ~ 3 난수
		
		//유저		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 선택하세요(1.가위/2.바위/ 3.보) : ");
		int user = sc.nextInt();
		
		//조기리턴
		if(!(user > 1 || user < 3)) {
			System.out.println("1 ~ 3 사이의 수를 입력하셔야 합니다.");
			return;
		}
		

			System.out.println("======= 결과 =======");
			System.out.println(user == 1 ? "당신은 가위를 냈습니다." : (user == 2 ? "당신은 바위를 냈습니다." : "당신은 보를 냈습니다."));
			System.out.println(computer == 1 ? "컴퓨터는 가위를 냈습니다." : (computer == 2 ? "컴퓨터는 바위를 냈습니다." : "컴퓨터는 보를 냈습니다."));
			System.out.println("===================");		
			if(computer == user) {
				System.out.println("비겼습니다.");
			}
			else if((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
				System.out.println("당신이 이겼습니다.");
			}
			else {
				System.out.println("당신이 졌습니다.");
			}
	}
}
