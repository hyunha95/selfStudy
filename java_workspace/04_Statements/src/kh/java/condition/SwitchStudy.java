package kh.java.condition;

import java.util.Scanner;

public class SwitchStudy {

	public static void main(String[] args) {
		SwitchStudy study = new SwitchStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	public void test5() {
			int num = menu();
			int price = 0;
			String menuName = "";
			
			switch(num) {
			case 1: price = 8000; menuName = "순대국"; break;
			case 2: price = 7000; menuName = "감자국"; break;
			case 3: price = 7500; menuName = "김치찌게"; break;
			default: 
				endMsg(); 
				return;
			}
			System.out.printf("%d. %s(%d원)",num, menuName, price);
	}
	
	/**
	 * 사용자한테 메뉴를 노출하고, 선택한 번호를 리턴하는 메소드
	 * @return
	 */
	public int menu() {
		Scanner sc = new Scanner(System.in);
		String menu = "----------------------\n"
					+ "오늘의 메뉴\n"
					+ "----------------------\n"
					+ "1. 순대국(8000원)\n"
					+ "2. 감자국(7000원)\n"
					+ "3. 김치찌게(7500원)\n"
					+ "----------------------\n"
					+ "선택 : ";
		System.out.print(menu);
		int num = sc.nextInt();
		return num;
	}
	
	/**
	 * 90 ~ 100 : A
	 * 80 ~ 89 : B
	 * 70 ~ 79 : C
	 * 60 ~ 69 : D
	 * ~ 59 : F
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = ' ';
		
		switch(score / 10) {
		case 10:
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default : grade = 'F';
		}
		
		System.out.printf("학점은 %c 입니다.%n", grade);
		
	}
	/**
	 * switch의 fall-through처리 (브레이크 없이 계속 실행됨)
	 * 회원등급 상은품 지급 정책: 
	 * 1. GOLD : 스마트tv, 무선청소기, 두루마리휴지
	 * 2. SILVER : 무선청소기, 두루마리휴지
	 * 3. BRONZE : 두루마리휴지
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원등급을 입력하세요. (GOLD | SILVER | BRONZE) : ");
		String grade = sc.next().toUpperCase();
//		String present = null; //가리키는 주소없음.
		String present = "";
		
		switch(grade) {
		case "GOLD" : present = "스마트tv, ";
		case "SILVER" : present += "무선청소기, "; 
		case "BRONZE" : present += "두루마리휴지"; break;
		default : System.out.println("잘못 입력하셨습니다."); return;
		}
		System.out.printf("당신의 선물은 [%s]입니다. %n", present);
	}
	
	/**
	 * 사용자 입력을 받아서
	 *  -> 순대국(8000원)을 선택하셨습니다.
	 *  -> 해당하는 메뉴가 없습니다. 종료합니다.
	 *  
	 *  메뉴와 가격에 해당하는 변수를 각각 사용할 것.
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
				String menu = "----------------------\n"
				+ "오늘의 메뉴\n"
				+ "----------------------\n"
				+ "1. 순대국(8000원)\n"
				+ "2. 감자국(7000원)\n"
				+ "3. 김치찌게(7500원)\n"
				+ "----------------------\n"
				+ "선택 : ";
		System.out.print(menu);
		int num = sc.nextInt();
		int price = 0;
		String menuName = "";
		
		switch(num) {
		case 1: price = 8000; menuName = "순대국"; break;
		case 2: price = 7000; menuName = "감자국"; break;
		case 3: price = 7500; menuName = "김치찌게"; break;
		default: endMsg(); return;
		}
		System.out.printf("%d. %s(%d원)",num, menuName, price);
	}
	
	public void endMsg() {
		System.out.println("잘못 입력하셨습니다.");
		return;
	}
	
	/**
	 * switch(계산식){
	 * 		case 값1: 실행코드1; break;
	 * 		case 값2: 실행코드2; break;
	 * 		case 값3: 실행코드3; break;
	 * 		...
	 * 		default : 기본실행구문;
	 * }
	 * 
	 *  계산식에 전달된 값을 경우에 따라 처리. break를 만나면 switch블럭을 탈출한다.
	 *  계산식에 올 수 있는 변수/값의 타입 byte short, int, char, String, enum 가능
	 *  long, float, double 실수형, boolean은 처리할 수 없다.
	 *  
	 */
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 과일을 선택하세요. ");
		System.out.println("1.사과 2.바나나 3.키위 4.아보카도");
		System.out.print("> ");
		int num = sc.nextInt();
		int price = 0;
		
		
			switch(num) {
			case 1: 
				price = 1000;
				break;
			case 2: price = 2000; break;
			case 3: price = 3000; break;
			case 4:	price = 4000; break;
			default : 
				System.out.println("잘못입력하셨습니다."); 
				return; // 조기리턴
		}
			System.out.println("가격은 " + price + "원입니다.");
	}
}
