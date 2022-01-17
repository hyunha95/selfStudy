package com.api.calendar;
/**
 * [문제3] 
패키지 com.api.calendar.CalcDday.test2
Calendar클래스를 이용해서 D-DAY계산기를 만드세요.
출력은 다음과 같습니다.

 ->  193일 남았습니다. 	(D-DAY 전)
 ->  D-DAY입니다.      	(D-DAY)	
 ->  20일 지났습니다.	(D-DAY가 지난 경우)
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcDday {

	public static void main(String[] args) {
		LocalDate dday = LocalDate.of(2022, 2, 17);
		LocalDate today = LocalDate.now();
		
		long days = ChronoUnit.DAYS.between(today, dday);
		long days1 = ChronoUnit.DAYS.between(dday, today);
		
		
		if(days>0) {
			System.out.println(days + "일 남았습니다.");
		}
		else if(days == 0) {
			System.out.println("D-DAY입니다.");
		}
		else {
			System.out.println(days1 + "일 지났습니다.");
		}
	}
	
}
