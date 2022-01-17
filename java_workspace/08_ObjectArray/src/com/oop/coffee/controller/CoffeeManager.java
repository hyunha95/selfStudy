package com.oop.coffee.controller;

import com.oop.coffee.model.dto.Coffee;
import java.util.Scanner;

public class CoffeeManager {

	public static final int THREE_COFFEE = 3;
	private Coffee[] arr = new Coffee[THREE_COFFEE];
	Scanner sc = new Scanner(System.in);
	
	public void inputCoffee() {
		for(int i = 0; i < THREE_COFFEE; i++) {
			System.out.print((i + 1)+ ". " +"원산지 : ");
			String origin = sc.next();
			System.out.print((i + 1)+ ". " +"지역 : ");
			String location = sc.next();
			arr[i] = new Coffee(origin, location);
		}
		System.out.println("입력 완료!");
	}
	
	public void printCoffee() {
		System.out.println("<세계3대커피>");
		System.out.println("-------------------");
		System.out.println("원산지\t\t지역");
		System.out.println("-------------------");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].printInfo());
		}
		System.out.println("-------------------");
	}
}

