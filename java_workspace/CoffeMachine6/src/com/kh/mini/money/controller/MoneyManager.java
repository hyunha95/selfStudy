package com.kh.mini.money.controller;

import java.util.Scanner;

import com.kh.mini.member.controller.MemberManager;
import com.kh.mini.member.model.io.MemberIO;
import com.kh.mini.money.model.io.MoneyIO;
import com.kh.mini.money.model.vo.Money;

public class MoneyManager {
	MoneyIO moneyIO = new MoneyIO();
    Money money = new Money();
    MemberIO memberIO = new MemberIO();
 
    int inputMoney; // 사용자 한테 금액 입력받아 저장할 변수 
    int charge; //거스름돈
  
   
//    public static void main(String[] args) {
//    	MoneyManager manager = new MoneyManager();
//    	manager.countMoney(100);
//	   
//    }
   
    public void countMoney(int price) {
//    	memberIO.writeJson(memberManager.setMember);//멤버쉽 저장
    	MemberManager memberManager = new MemberManager();
    	
    	money =	moneyIO.readFile();//파일의 돈을 가져와 객체로 저장
    	
		if(price == 0) {
			System.out.println("결제 완료!");
			System.out.println("음료를 받아가세요! 이용해주셔서 감사합니다.");
			
			moneyIO.writerFile(money);//파일저장
			System.exit(0);//종료
		}else {
			System.out.println("돈을 넣어주세요 : ");
			Scanner sc = new Scanner(System.in);
			inputMoney = sc.nextInt();
			
			if(inputMoney > price) {//투입금액이 더 크면
				charge = inputMoney - price; 
				if(money.getMoney() < charge) {
					System.out.println("거스름돈이 부족합니다 돈을 반환합니다.");
				}else {
					money.setMoney(money.getMoney() + price);//매출 추가
					System.out.println("거스름돈은 "+ charge + "원 입니다" );//거스름 반환
					System.out.println("음료를 받아가세요! 이용해주셔서 감사합니다.");
					moneyIO.writerFile(money);//파일저장
					System.exit(0);//종료
				}
			}else if(inputMoney < price ) {//투입금액이 부족하면
				System.out.println("투입한 금액이 부족합니다 "); 
			} else {
				money.setMoney(money.getMoney() + inputMoney);//금액이 동일하면 바로 넣어줌
				System.out.println("결제 완료!");
				System.out.println("음료를 받아가세요! 이용해주셔서 감사합니다.");
				moneyIO.writerFile(money);//파일저장
				System.exit(0);//종료
			}
		}
		
		
       
	  
	}
}

