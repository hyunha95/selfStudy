package kh.java.api.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeStudy {

	public static void main(String[] args) {
		LocalDateTimeStudy study = new LocalDateTimeStudy();
		study.test1();
//		study.test2();

	}
	
	/**
	 * dday구하기
	 */
	public void test2() {
		LocalDate dday = LocalDate.of(2022, 2, 17);
		LocalDate today = LocalDate.now();
		
		//1. ChronoUnit.DAYS.between // ~일
		long days = ChronoUnit.DAYS.between(today, dday);
		System.out.println("D-" + days);
		
		//2.LocalDate.until():Period // ~월 ~일
		Period period = today.until(dday);
		System.out.println(period);
		System.out.printf("%d년 %d개월 %d일 남았습니다.%n", 
						   period.getYears(),
						   period.getMonths(),
						   period.getDays());
	}
	
	/**
	 * java.time.LocalDate
	 * java.time.LocalTime
	 * java.time.LocalDateTime
	 * 
	 */
	public void test1() {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		int yyyy = today.getYear();
		System.out.println(yyyy);
		
		int MM = today.getMonthValue();
		System.out.println(MM);
		
		int dd = today.getDayOfMonth();
		System.out.println(dd);
		
		//Enum 상수모음.
//		DayOfWeek dayOfWeek = today.getDayOfWeek();
		int dayOfWeek = today.getDayOfWeek().getValue();
		System.out.println(dayOfWeek); //월(1) ~ 일(7)
		char[] days = {'월', '화', '수', '목', '금', '토', '일'};
		System.out.println(days[dayOfWeek - 1]);
		
	}

}