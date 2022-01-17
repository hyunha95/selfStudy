package com.api.calendar;

/**
 * [문제2] 
패키지 com.api.calendar.CalcYourDays.java
사용자로부터 생일(년, 월, 일)을 입력받고, 오늘이 태어난지 몇일 되었는지 출력하세요.
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcYourDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("생일 입력하기");
		System.out.print("년 :");
		int yyyy = sc.nextInt();
		System.out.print("월 : ");
		int MM = sc.nextInt();
		System.out.print("일 : ");
		int dd = sc.nextInt();
		LocalDate today = LocalDate.now();
		LocalDate birthDay = LocalDate.of(yyyy, MM, dd);
		
		long days = ChronoUnit.DAYS.between(birthDay, today);
		System.out.println(days + 1);
	}
}
