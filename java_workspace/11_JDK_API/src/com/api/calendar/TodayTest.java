package com.api.calendar;

/**
 * [문제1]
패키지 com.api.calendar.TodayTest
오늘 날짜를 다음 형식으로 출력하세요.

-> 오늘은 2019년 8월 5일 목요일
 */
import java.util.Calendar;

public class TodayTest {

	public static void main(String[] args) {
		TodayTest test = new TodayTest();
		Calendar cal1 = Calendar.getInstance();
		test.printCalendar(cal1);
	}
	
	public void printCalendar(Calendar cal) {
		int yyyy = cal.get(Calendar.YEAR);
		int MM = cal.get(Calendar.MONDAY);
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int i = cal.get(Calendar.DAY_OF_WEEK); //일(1)~토(7)
		String[] daysOfWeek = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		System.out.printf("오늘은 %d년 %d월 %d일 %s", yyyy, MM, dd, daysOfWeek[i - 1]);
	}
}
