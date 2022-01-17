package com.collection.set.cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CartMain {
	Scanner sc = new Scanner(System.in);
	Set<Cart> carts = new HashSet<>();

	public static void main(String[] args) {
		CartMain cm = new CartMain();

		System.out.println("상품명에 exit 입력시 탈출");
		cm.add();
		System.out.println("-----------------");
		cm.search();
		System.out.println("-----------------");
		cm.view();

		
		System.out.println("시스템 종료");

	}
	
	public void add() {
		while(true) {
			System.out.print("상품명 : ");
			String name = sc.nextLine();
			if("exit".equals(name))
				return;
			for(Cart c : carts) {
				if(c.getName().equals(name))
					System.out.println("이미 등록된 상품입니다.");
			}
			System.out.print("수량 : ");
			int count = sc.nextInt();
			sc.nextLine();
			carts.add(new Cart(name, count));
		}
	}
	
	public void search() {
		while(true) {
			System.out.print("상품명 검색 : ");
			String name = sc.next();
			if("exit".equals(name))
				break;
			for(Cart c : carts) {
				if(c.getName().equals(name)) {
					System.out.println(c.getName() + " - " + c.getCount() +"개가 담겨있습니다.");
					return;
				}
			}
			System.out.println("조회한 상품은 장바구니에 없습니다.");
			
		}
	}
	
	public void view() {
		List<Cart> list = new ArrayList<>(carts);
//		list.sort(new CartNameAsc());
		int i = 1;
		int sum = 0;
		for(Cart c : carts)
			System.out.println(i++ + ". " + c.getName() + " - " + c.getCount() + "개");
			sum++;
	System.out.println("-----------------");
	System.out.println("총 " + sum + "개의 상품이 담겨 있습니다.");
	
	}
	
	
}








