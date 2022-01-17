package kh.java.basic;

// java.lang패키지의 클래스는 워낙 사용빈도가 많으므로, import문 생략가능함.
// import java.lang.*;

public class CommandLineArgsStudy {
	
	/**
	 * 프로그램 실행시에 사용자입력값 전달하는 방법
	 * 
	 * 공백기준으로 쪼갤수 있는 하나의 문자열을 전달시, String[]로 main메소드에 전달
	 * "안녕하세요 1234 56.78 true" 
	 * 
	 * Run configurations -> Arguments -> program arguments에 값 입력
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		for(int i = 0; i < args.length; i++) {
//			System.out.printf("%d : [%s]%n", i, args[i]);
//		}
		
		CommandLineArgsStudy study = new CommandLineArgsStudy();
		study.test1(args);
		
		System.out.println("프로그램 종료!");
	}
	
	/**
	 * 사용자 정보 처리(형변환)
	 * 
	 * honggd 홍길동 35 175.7 남 false
	 * 
	 * @param args
	 */
	public void test1(String[] args) {
		String id = null;
		String name = null;
		int age = 0;
		double height = 0.0;
		char gender = ' ';
		boolean married = false;
		
		for(int i = 0; i < args.length; i++) {
			switch(i) {
			case 0: id = args[i]; break;
			case 1: name = args[i]; break;
			case 2: age = Integer.parseInt(args[i]); break; // 정수로 구성된 문자열을 변환
			case 3: height = Double.parseDouble(args[i]); break; // 실수로 구성된 문자열을 변환
			case 4: gender = args[i].charAt(0); break;
			case 5: married = Boolean.parseBoolean(args[i]); break;
			}
		}
		
		System.out.println("id = " + id);
		System.out.println("name = " + name);
		System.out.println("age = " + (age + 1));
		System.out.println("height = " + height);
		System.out.println("gender = " + gender);
		System.out.println("married = " + married);
	}
}







