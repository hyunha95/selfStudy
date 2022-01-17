package kh.java.api.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CalendarDateStudy {

	public static void main(String[] args) {
		CalendarDateStudy study = new CalendarDateStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();

	}
	
	/**
	 * java.util.Date
	 * 
	 */
	public void test4() {
		Date now = new Date();
		System.out.println(now);
		
		// Calendar객체로 변환
		Calendar cal = new GregorianCalendar(1999, 9, 10);
		printCalendar(cal);
		cal.setTime(now);
		printCalendar(cal);
		
		// Date객체로 변환
		Date past = new Date(cal.getTimeInMillis());
		System.out.println(past);
	}
	
	/**
	 * 수료일(d-day) 남은 일수 계산하기
	 * 
	 * 1. millis초단위로 변환해서 차이를 구하기 
	 * 2. 다시 날짜차이로 변환 diff / 1000 / 60 / 60 / 24
	 */
	public void test3() {
		Calendar dday = new GregorianCalendar(2022, 1, 17);
		Calendar today = Calendar.getInstance();
		
		// 1. millis차이 구하기 Unix(Epoch) Time
		double diff = dday.getTimeInMillis() - today.getTimeInMillis();
		// 2. 다시 날짜차이로 변환
		diff = diff / 1000 / 60 / 60 / 24;
		System.out.println(diff);
		
		// 반올림 Math.round, 올림 Math.ceil, 버림 Math.floor
		System.out.printf("D-%.0f%n",Math.ceil(diff));
	}
	
	/**
	 * 특정날짜 세팅하기
	 */
	public void test2() {
		Calendar day1 = new GregorianCalendar(2022, 1 - 1, 1);
		printCalendar(day1);
		Calendar day2 = new GregorianCalendar(2022, 1, 17, 21, 50);
		printCalendar(day2);
	}
	
	/**
	 * java.util.Calendar
	 */
	private void test1() {
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		/*
		 * java.util.GregorianCalendar[
		 * time=1628157942708, // 1970년 1월 1일 00:00:00 이후로 흐른 mills초 (unix time/epoch time)
		 * areFieldsSet=true,
		 * areAllFieldsSet=true,
		 * lenient=true,
		 * zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],
		 * firstDayOfWeek=1,
		 * minimalDaysInFirstWeek=1,
		 * ERA=1,
		 * YEAR=2021,
		 * MONTH=7,          // 0 ~ 11
		 * WEEK_OF_YEAR=32,
		 * WEEK_OF_MONTH=1,
		 * DAY_OF_MONTH=5,
		 * DAY_OF_YEAR=217,
		 * DAY_OF_WEEK=5,  // 일요일 = 1 ~ 토요일 = 7
		 * DAY_OF_WEEK_IN_MONTH=1,
		 * AM_PM=1,        // 오전 = 0, 오후 = 1
		 * HOUR=7,
		 * HOUR_OF_DAY=19,
		 * MINUTE=5,
		 * SECOND=42,
		 * MILLISECOND=708,
		 * ZONE_OFFSET=32400000,
		 * DST_OFFSET=0
		 * ]
		 */
		 
		printCalendar(cal1);
		
		Calendar cal2 = new GregorianCalendar();
		printCalendar(cal2);
	}
	
	/**
	 * 2021년 8월 5일 (목)오후 7시 11분 23초
	 *
	 */
	public void printCalendar(Calendar cal) {
		int yyyy = cal.get(Calendar.YEAR);
		int MM = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int i = cal.get(Calendar.DAY_OF_WEEK); // 일(1) ~ 토(7)
		char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};
		int AM = cal.get(Calendar.AM_PM); // 오전(0) / 오후(1)
		int hh = cal.get(Calendar.HOUR);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
				
		System.out.printf("%d년 %d월 %d일 (%c) %s %d시 %d분 %d초%n", 
						  yyyy, MM, dd, daysOfWeek[i - 1], 
						  AM == 0 ? "오전" : "오후",hh, mm, ss);
	}
}
