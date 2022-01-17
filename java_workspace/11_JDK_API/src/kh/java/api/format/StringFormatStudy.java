package kh.java.api.format;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringFormatStudy {

	public static void main(String[] args) {
		StringFormatStudy study = new StringFormatStudy();
		study.test1();
//		study.test2();

	}

	/**
	 * 날짜 format
	 * java.text.SimpleDateFormat
	 * (Date객체만 처리)
	 */
	private void test2() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일 a hh:mm:ss", Locale.CHINESE);
		String s = sdf.format(now);
		System.out.println(s);
		
		
	}

	/**
	 * 숫자 format 
	 * java.text.DecimalFormat
	 */
	private void test1() {
		int price = 123_456_789;
		DecimalFormat df = new DecimalFormat("￦#,###"); // 세자리마다 콤마 찍어
		String s = df.format(price);
		System.out.println(s);

		double num = 123.456;
		//0 : 해당자리의 숫자가 없을 때 0으로 채움
//		df.applyPattern("#.00000"); //format객체 패턴변경 
		//# : 해당자리의 숫자가 없을 때 비워둠.
		df.applyPattern("#.#####"); 
		//반올림처리
		df.applyPattern("#.##"); 
		s = df.format(num);
		System.out.println(s);
		
	}
}
