package test.controller;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Test6 t = new Test6();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		outer:
		do {
			System.out.print("1~5사이에 숫자를 입력하세요. : ");
			int inputNum  = sc.nextInt();
			switch(inputNum) {
			case 1:
				System.out.println("1 : ** 입력이 정상적을 되었습니다! **");
				break outer;
			case 2:
				System.out.println("2: ** 조회가 시작되었습니다! **");
				break outer;
			case 3:
				System.out.println("3 : ** 수정이 정상적으로 되었습니다! **");
				break outer;
			case 4:
				System.out.println("4 : ** 삭제가 정상적으로 되었습니다! **");
				break outer;
			case 5:
				System.out.println("5. : ** 정상적으로 종료 되었습니다! **");
				break outer;
			default:
				System.out.println("** 다시 입력해 주세요! **");
				continue;
			}
		} while(true);
		System.out.println("종료!");
	}
}
