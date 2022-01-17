/*
 [static메소드 실습문제]
package com.oop.method.static_;
//실행클래스 Run : 적절한 방법으로 static 메소드 호출하기
//기능제공클래스 StaticMethod
public class StaticMethod {
	//static method
	//1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
	//메소드명 : toUpper(String) : String
	//2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
	//메소드명 : setChar(String, int, char) : String
	//3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
	//메소드명 : getAlphabetLength(String) : int
	//4. 전달한 문자열값을 하나로 합쳐서 리턴 
	//메소드명 : concat(String, String) : String
}
 */

package com.oop.method.static_;

public class Run {

	public static void main(String[] args) {
		System.out.println(StaticMethod.toUpper("apple"));
		
		System.out.println(StaticMethod.setChar("apple", 0, 'k'));
		
		System.out.println(StaticMethod.getAlphabetLength("apple"));
		
		System.out.println(StaticMethod.concat("Hello", "world"));
	
	}
}
