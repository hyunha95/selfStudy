package kh.java.api.string;

import java.util.StringTokenizer;

public class StringStudy {

	public static void main(String[] args) {
		StringStudy study = new StringStudy();
//		study.test1();
//		study.test2();
		study.test3();

	}
	
	/**
	 * CSV (Comma Separated Value) 콤마로 구분된 값
	 * 홍길동,신사임당,세종대왕,장보고,이순신
	 * 홍길동/신사임당/세종대왕/장보고/이순신
	 * (구분자는 실제값에서 절대 사용하지 않는 문자일것.)
	 * 
	 * 1. String.split("구분자")
	 * 		빈문자열도 데이터로 취급
	 * 		구분자문자열을 문자열자체로 취급 / 정규표현식을 이용해 문자단위처리 가능 [] 한글자목록
	 * 2. StringTokenizer
	 * 		빈문자열을 제거
	 * 		구분자문자열을 문자단위로 사용
	 * 
	 */
	public void test3() {
		String data = "홍길동, 신사임당,,,세종대왕, , 장보고, 이순신";
		
		//1. split
		String[] arr = data.split("[, ]");
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			String name = arr[i];
			System.out.println("["+name +"]");
		}
		
		System.out.println("--------------------------");
		
		//2. StringTokenizer
		StringTokenizer tokenizer = new StringTokenizer(data, ", ");
		System.out.println(tokenizer.countTokens());
		
		while(tokenizer.hasMoreTokens()) {
			String name = tokenizer.nextToken();
			System.out.println(name);
		}

		System.out.println(tokenizer.countTokens()); //토큰은 사용되면 없어진다.
	}
	
	/**
	 * StringBuilder 동기화기능 없음
	 * StringBuffer  동기화기능 있음(멀티스레드환경에 적합)
	 * 
	 * - 문자열리터럴 pool을 이용하지 않음. 
	 * - 내부 문자열 객체를 변경가능함.
	 */
	public void test2() {
		StringBuilder sb = new StringBuilder("java");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
		sb.append("oracle");
		System.out.println(sb);
		System.out.println(sb.hashCode());
	}
	
	/**
	 * String - immutable 불변
	 * 
	 * 참조형이지만, 기본형처럼 리터럴 값대입을 지원한다.
	 * 
	 * heap영역의 문자열저장소 String literal pool에 문자열객체(불변)를 생성하고 이를 공유.
	 * 더하기연산시, 문자열객체 변경이 아닌, 새로운 문자열을 생성하고, 이 주소값을 전달한다.
	 * 
	 * 문자열 동등성(값) 비교에는 equals를 사용한다.
	 * 
	 */
	public void test1() {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		// 문자열 값비교는 equals를 사용한다.
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		
		// 주소값비교
		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3); // false
		System.out.println(s1 == s4); // false
		
		//해쉬코드
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		// 더하기연산
		s1 += "oracle";
		s2 += "oracle";
		s3 += "oracle";
		s4 += "oracle";
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
	}

}
