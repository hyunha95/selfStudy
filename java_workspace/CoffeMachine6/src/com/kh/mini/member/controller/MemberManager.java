package com.kh.mini.member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.kh.mini.member.model.io.MemberIO;
import com.kh.mini.member.model.vo.Member;
import com.kh.mini.menu.controller.MenuManager;
import com.kh.mini.menu.model.vo.Menu;
import com.kh.mini.money.controller.MoneyManager;
import com.kh.mini.stock.model.vo.Stock;

public class MemberManager {
	public Set<Member> setMember;
	public String userName;
	List<Menu> list;
	Scanner sc = new Scanner(System.in);
	//MemberManager memberManager = new MemberManager();
	MenuManager menuManager = new MenuManager();
	MoneyManager moneyManager = new MoneyManager();
	MemberIO memberIO = new MemberIO();
	
	int totalPrice;
	
	public void checkMember(int price) {//전화번호를 입력받아 등록된 회원인지 검사후 포인트 알려줌
		setMember = new MemberIO().readJson();
		list = menuManager.orderList();
		totalPrice = price;
		while(true) {
			System.out.println("전화번호11자리를 입력해주세요");
			String number = sc.next();
			if(number.length() == 11) {//전화번호가 11자리이면
				Iterator<Member> itor = setMember.iterator();
				
				boolean flag = false;
				while(itor.hasNext()) {
					Member member = itor.next();
//					System.out.println(m1);
					userName = member.getName();//필드에 저장 
					String num = member.getNumber();
//					String name = member.getName();
					int memberPoint = member.getPoint();
					if(num.equals(number)) {
						addPoint(num, price);
						System.out.println(blindName(userName) + "님 잔여포인트 " + memberPoint + "점 입니다");
						
						flag = true;
					}
				}
				if(!flag) {
					System.out.println("사용자를 찾을 수 없습니다.");
					String selection = "1. 신규가입\n"
									 + "0. 돌아가기\n"
									 + ">> 선택 : ";
					while(true) {
						System.out.println(selection);
						int input = sc.nextInt();
						switch (input) {
						case 1:
							String inputName = null;
							String inputNumber = null;
							String inputPassword = null;
							while(true) {
								try {
									System.out.println("성함을 입력하세요");
									inputName = sc.next();
									System.out.println("전호번호를 입력하세요");
									inputNumber = sc.next();
									System.out.println("비밀번호 입력하세요");
									inputPassword = sc.next();
									break;
								} catch (Exception e) {
									System.out.println("다시 입력하세요");
									sc.nextLine();
								}
							}
							System.out.println();
							addMember(inputName, inputNumber, inputPassword);
							memberIO.writeJson(setMember);
							break;
						case 0:
							System.out.println("이전으로 이동");
							return;
						default:
							break;
						}
					}
				}
				System.out.println("포인트를 사용하시겠습니까?");
				String selection = "1. 사용\n"
								+ "2. 사용 안함\n"
								+ ">> 선택 : ";
				
				while(true) {
					System.out.println(selection);
					int input = sc.nextInt();
					switch (input) {
					case 1:
						System.out.println("비밀번호를 입력하세요");
						if(checkPassword(number, sc.next())) {
							System.out.println("사용금액을 입력해주세요");
							while(true) {
								input = sc.nextInt();
								if(totalPrice >= input) {
									int result = usePoint(number, input);
									memberIO.writeJson(setMember);
									if(result == 0) {
//										System.out.println("결제가 완료되었습니다!");
										
										moneyManager.countMoney(0);
									}else {
										moneyManager.countMoney(result);//잔여금액 결제
									}
									
								}else {
									System.out.println("총 금액 " + price + "보다 많이 입력하셨습니다");
									System.out.println("다시 입력하세요");
									sc.nextLine();
								}
							}
							
							
						}else {
							System.out.println("비밀번호가 일치하지 않습니다.");
						}
						break;
					case 2:
						//결제메소드, 적립금 사용안함
						moneyManager.countMoney(price);
						
						break;
					default:
						System.out.println("잘못입력하셨습니다.");
						break;
					}
				}
				
			}else {
				sc.nextLine();
				System.out.println("다시입력하세요");
			}
		}
		
	}
	public boolean checkPassword(String number, String password) {
		Iterator<Member> itor = setMember.iterator();
		
		while(itor.hasNext()) {
			Member m1 = itor.next();
//			System.out.println(m1);
			String num = m1.getNumber();
			String pass = m1.getPassword();
			if(number.equals(num) && password.equals(pass)) {
				System.out.println("회원인증 성공!");
				return true;
			}
		}
		return false;
	}
	public String blindName(String name) {//이름 익명화(홍*동)
		char[] arr = name.toCharArray();
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			if(i == (arr.length/2)) {
				str += "*";
			}else {
				str += arr[i];
			}
		}
		return str;
	}
	
	public int usePoint(String number, int point) {
		
		Iterator<Member> itor = setMember.iterator();
		
		while(itor.hasNext()) {
			Member m1 = itor.next();
//			System.out.println(m1);
			String num = m1.getNumber();
			int memberPoint = m1.getPoint();
			if(num.equals(number)) {
				if(memberPoint > point) {
					m1.setPoint(m1.getPoint() - point);//회원이 가진 포인트보다 크거나 같은 경우만 포인트 소진
					totalPrice -= point;
					System.out.println(point + "원 포인트 사용 완료!");
				}
			}
		}
		return totalPrice;
	}
	public void addMember(String name, String number, String password) {
		boolean result = setMember.add(new Member(name, number, 500, password));
		if(result) {
			System.out.println("회원가입 완료!");
		}else {
			System.out.println("이미 가입되어 있는 번호 입니다");
		}
//		System.out.println(setMember);
		
	}
	public void addPoint(String number, int price) {
		int point = (int) (price * 0.01);
		
		Iterator<Member> itor = setMember.iterator();
		while(itor.hasNext()) {
			Member m1 = itor.next();
//			System.out.println(m1);
			String num = m1.getNumber();
			if(num.equals(number)) {
				int newPoint = m1.getPoint() + point;
				m1.setPoint(newPoint);
				setMember.add(m1);
			}
		}
		
		System.out.println(point + "점 적립 완료!");
	}
	
	
}
