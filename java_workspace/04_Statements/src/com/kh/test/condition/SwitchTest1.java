package com.kh.test.condition;

import java.util.Scanner;

public class SwitchTest1 {

	public static void main(String[] args) {
		SwitchTest1 t = new SwitchTest1();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------- menu -------------");
		System.out.println("1. 가정용 (50원/liter)");
		System.out.println("2. 상업용 (45원/liter)");
		System.out.println("3. 공업용 (30원/liter)");
		System.out.println("--------------------------------");
		System.out.print("메뉴번호를 선택하세요. ==> ");
		int menuNum = sc.nextInt();
		System.out.print("물 사용량을 입력하세요. ==> ");
		int water = sc.nextInt();
		int price = 0;
		String name = "";
		
		switch(menuNum) {
		case 1:
			price = 50; name = "가정용" ;break;
		case 2:
			price = 45; name = "상업용" ;break;
		case 3:
			price = 30; name = "공업용" ;break;
		default:
			System.out.println("메뉴번호는 1,2,3만 가능합니다."); 
			return;
		}
		
		int usedPrice = price * water;
		double tax = usedPrice * 0.05;
		double totalPrice = usedPrice + tax;
		System.out.println("------------<<수도세>>-------------");
		System.out.println("선택메뉴번호 : "+ menuNum +". " + name + "를 선택하셨습니다.");
		System.out.println("사용요금 : " + usedPrice);
		
		
	}
}

/*
 * @com.kh.test.condition.SwitchTest1
수도세를 구하는 프로그램을 작성하세요. 
사용자에게 사용용도와 물사용량을 입력받고, 이에따른 수도세를 계산해 출력하세요.(switch문 사용할 것.)
* 사용요금: 용도별 가격(1liter)  * 사용량
* 수도세: 사용요금의 5%
* 총사용요금: 사용요금 + 수도세
* 사용용도메뉴에서 1,2,3번이외를 선택시에는 "메뉴번호는 1,2,3만 가능합니다."를 출력하고, 프로그램을 종료할 수 합니다.
사용자입력예시)
        ----------menu----------
        1. 가정용 (50원/liter)
        2. 상업용 (45원/liter)
        3. 공업용 (30원/liter)
        -------------------------
        메뉴번호를 선택하세요. ==> 2
        물 사용량을 입력하세요. ==> 250
출력예시)
        ----------<<수도세>>-----------
        선택메뉴번호 :  2. 상업용(업소에서 사용하실 경우)를 선택하셨습니다. 
        사용요금 : 11250
        수도세 : 562
        총수도요금 : 11812원
 */
