package com.oop.method.static_;

import java.util.Arrays;

public class StaticMethod {
	//static method
		//1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
		//메소드명 : toUpper(String : String)
		public static String toUpper(String toUpper) {
			String result = toUpper.toUpperCase();
			return result;
		}
		
		//2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
		//메소드명 : setChar(String, int, char) : String
		public static String setChar(String str, int indexNum, char change) {
		char[] chArr = new char[str.length()];
		
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
			if(i == indexNum) {
				chArr[i] = change;
			}
		}
		return String.valueOf(chArr);
		}
		
		//3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
		public static int getAlphabetLength(String str) {
			char[] chArr = new char[str.length()];
			int sum = 0;
			for(int i = 0; i < chArr.length; i++) {
				chArr[i] = str.charAt(i);
			}
			for(int i = 0; i < chArr.length; i++) {
				if((chArr[i] >= 'a' && chArr[i] <= 'z') || 
						(chArr[i] >= 'A' && chArr[i] <= 'Z')) {
					sum += 1;
				}
			}
			
			return sum;
		}
		
		public static String concat(String first, String second) {
			String result = first.concat(second);
			
			return result;
		}
		
		
}