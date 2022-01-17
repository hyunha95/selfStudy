package kh.java.loop;

import java.util.Scanner;

public class WhileLoopStudy {

	public static void main(String[] args) {
		WhileLoopStudy study = new WhileLoopStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	/**
	 * 메뉴를 반복문을 통해 제공하고,
	 * 메뉴번호, 수량을 입력받는다.
	 * 추가주문 여부에 따라 반복할지를 결정할 것.
	 * 주문이 끝나면 총 금액을 출력.
	 *  // 1. 메뉴를 반복 출력 - 사용자 메뉴 선택
	 * // 2. 수량 : 한턴에 선택한 메뉴 금액
	 * // 3. 누적합
	 * // 4. 계속여부 처리
	 * // 5. 누적합 출력
	 * 
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		
		String menu = "메뉴\r\n"
				+ "	김밥류 ===================\r\n"
				+ "	1.원조김밥===========1500원\r\n"
				+ "	2.치즈김밥===========2000원\r\n"
				+ "	3.참치김밥===========2300원\r\n"
				+ "	라면류 ===================\r\n"
				+ "	4.그냥라면===========3000원\r\n"
				+ "	5.치즈라면===========3500원\r\n"
				+ "	6.짬뽕라면===========4000원\r\n"
				+ "	분식류 ===================\r\n"
				+ "	7.떡볶이=============2500원\r\n"
				+ "	8.순대==============2500원\r\n"
				+ "	9.오뎅==============1000원\r\n"
				+ "	기타 ====================\r\n"
				+ "	10.음료수===========1000원\r\n"
				+ "-------------------------\r\n"
				+ "선택 : ";
		
		int sum = 0;
		char yn = 'y';
		
		do {
			System.out.print(menu);
			int choice = sc.nextInt();
			System.out.print("수량 : ");
			int cnt = sc.nextInt();
			int price = 0;
			switch(choice) {
			case 1: price = 1500; break;
			case 2: price = 2000; break;
			case 3: price = 2300; break;
			case 4: price = 3000; break;
			case 5: price = 3500; break;
			case 6: price = 4000; break;
			case 7: price = 2500; break;
			case 8: price = 2500; break;
			case 9: price = 1000; break;
			case 10: price = 1000; break;
			default : System.out.println("잘못 입력하셨습니다"); 
				continue; // 이하 코드를 실행하지 않고 반복문의 시작(조건문)으로 돌아간다.
			}
			
			int total = price * cnt;
			sum += total;
			
			System.out.print("더 주문하시겠습니까? (y/n) : ");
			yn = sc.next().charAt(0);
			if(yn == 'n') {
				break;
			}
		
		}while(yn == 'y');
		
		System.out.println("결제할 총 금액은 [" + sum + "] 입니다.");
	}
		
		
		//내 풀이
//		Scanner sc = new Scanner(System.in);
//		int price = 0;
//		int menuCount = 0;
//		int totalCost = 0;	
//		
//		String menu = "메뉴\r\n"
//					+ "	김밥류 ===================\r\n"
//					+ "	1.원조김밥===========1500원\r\n"
//					+ "	2.치즈김밥===========2000원\r\n"
//					+ "	3.참치김밥===========2300원\r\n"
//					+ "	라면류 ===================\r\n"
//					+ "	4.그냥라면===========3000원\r\n"
//					+ "	5.치즈라면===========3500원\r\n"
//					+ "	6.짬뽕라면===========4000원\r\n"
//					+ "	분식류 ===================\r\n"
//					+ "	7.떡볶이=============2500원\r\n"
//					+ "	8.순대==============2500원\r\n"
//					+ "	9.오뎅==============1000원\r\n"
//					+ "	기타 ====================\r\n"
//					+ "	10.음료수===========1000원\r\n"
//					+ "-------------------------\r\n"
//					+ "선택 : ";
//		// 1. 메뉴를 반복 출력 - 사용자 메뉴 선택
//		while(true) {
//			System.out.print(menu);
//			int menuNum = sc.nextInt();
//
//			switch(menuNum) {
//			case 1 : price = 1500; break;
//			case 2 : price = 2000; break;
//			case 3 : price = 2300; break;
//			case 4 : price = 3000; break;
//			case 5 : price = 3500; break;
//			case 6 : price = 4000; break;
//			case 7 : price = 2500; break;
//			case 8 : price = 2500; break;
//			case 9 : price = 1000; break;
//			case 10 : price = 1000; break;
//			default : System.out.println("잘못입력하셨습니다.");
//				return;
//			}
//			// 2. 수량 : 한턴에 선택한 메뉴 금액
//			System.out.print("수량을 입력해주세요. : ");
//			menuCount = sc.nextInt();
//			// 3. 누적합
//			totalCost += (price * menuCount);
//			// 4. 계속여부 처리
//			System.out.println("계속 주문하기(y/n)");
//			char yn = sc.next().charAt(0);
//			if(yn == 'n') {
//				// 5. 누적합 출력
//				System.out.println("총 금액은 : " + totalCost);
//				break;
//			}
//		}
//	}
		

	/**
	 * while문을 do...while처럼 사용하기
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("--- 게임시작 ---");
			System.out.println("얍~ 빡 ~ 쿵 ~");
			System.out.println("--- 게임끝 ---");
			
			System.out.print("더 하시겠습니다?(y/n) : ");
			char yn = sc.next().charAt(0);
			
			if(yn != 'y') {
				break;
			}
		}
	}
	
	/**
	 * do ... while
	 * 
	 * 반복블럭을 무조건 한번 실행한 후에 조건식에 따라 반복여부를 결정
	 * 
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		char yn = ' ';
		do {
			System.out.println("--- 게임시작 ---");
			System.out.println("얍~ 빡 ~ 쿵 ~");
			System.out.println("--- 게임끝 ---");
			
			System.out.print("더 하시겠습니다?(y/n) : ");
			yn = sc.next().charAt(0);
			
		} while(yn == 'y');
		
		System.out.println("종료!");
	}
	
	/**
	 * 구구단을 while문 출력
	 * 
	 *  7 * 1 = 7
	 *  7 * 2 = 14
	 *  7 * 3 = 21
	 *  ...
	 *  7 * 8 = 56
	 *  7 * 9 = 63
	 *  
	 */
	public void test2() {
		final int dan = 7;
		int i = 1;
		while(i <= 9) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
			i++;
		}
		
		// 누적합 1 ~ 10
		int sum = 0;
		int j = 1;
		
		while(j <= 10) {
			sum += j++;
		}
		System.out.println("sum = " + sum);
	}
	
	/**
	 * 초기식
	 * 
	 * while(조건식){
	 * 		
	 * 		반복처리구문		
	 * 
	 * 		증감식
	 *  }
	 *  
	 */
	public void test1() {
//		for(int i = 0; i < 10; i++) {
//			System.out.println("hello world");
//		}
		
//		int i = 1;
//		while(i <= 10) {
//			System.out.println("hello world" + i);
//			i++;
//		}
		
		//10 9 8 7 6 5 4 3 2 1 
		int i = 10;
		while(i >= 1) {
			System.out.print(i + " ");
			i--;
		}
		System.out.println();
		
		int k = 1;
		int a = 9;
		while(k <= 10) {
			System.out.print((k + a)+ " ");
			k++;
			a -= 2;
		}
		
		
		System.out.println(" ");
		//1 3 5 7 9 11 13 15 17 19
		int j = 1;
		while(j <= 19) {
			System.out.print(j + " ");
			j += 2;
		}
	}
}









