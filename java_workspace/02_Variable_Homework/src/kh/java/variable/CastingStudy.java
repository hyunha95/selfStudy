package kh.java.variable;

public class CastingStudy {

	public static void main(String[] args) {
		
		CastingStudy study = new CastingStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
	}
	
	/**
	 * @실습문제 : 형변환과정 이해하기
	 */
	public void test4() {
		System.out.println('A' + 0); // char + int => int + int => int
		System.out.println('A' + '0'); // char + char => int(65) + int(48) => int(113) 
		System.out.println((char)65); // 'A' 
		
		byte bnum = 125;
		char ch = 'C';
		System.out.println(bnum + ch); // byte + char => int(125) + int(67) => 192 
		
		boolean bool;
		
		bool = 2.0 == (5 / 2); // double == (int / int) => double == int => double == double
		System.out.println(bool);
		
		bool = 'C' == 65 + 2; // char == int => int == int 
		System.out.println(bool);
		
		bool = 'A' == 'B' - 1; // char == (char - int) => char == (int - int) 
		System.out.println(bool);
		
		bool = 'a' != 97;  // 부정비교연산 : 같지 않다면 true, 같으면 false
		// char != int => int != int
		System.out.println(bool);
		
	}
	
	
	/**
	 * 예외상황
	 * 1. int보다 작은 byte, short, char는 산술연산시 자동으로 int로 형변환처리된다.
	 * 2. char타입에 int를 대입가능하다. 자동형변환 처리된다.
	 */
	public void test3() {
		byte a = 100;
		byte b = 10;
		byte result = (byte)(a + b); // int + int => int
		System.out.println(result);
		
		char ch = 97; // char = int
		System.out.println(ch);
		
		
	}
	
	/**
	 * 명시적형변환 : 데이터 손실이 있을수 있음.
	 * 
	 */
	public void test2() {
		int num = (int) 3.7;
		System.out.println(num);
		
		int a = 10;
		int b = 4;
		double result = (double)a / b;
		System.out.println((double)a / b); // double(10.0) / int(4) => double / double => double
		System.out.println(a * 1.0 / b); // int * double / int => d * d / i => d / i => d / d
		
		// 2147483647 => 2147483648
		int i = Integer.MAX_VALUE;
		System.out.println((long)i + 1);
		System.out.println(i + (long)1);
		System.out.println(i + 1L);
		
	}
	
	/**
	 * 컴퓨터 작동원리
	 * 1. 값(literal)은 같은 타입의 변수에만 대입할 수 있다. 
	 * 2. 같은 타입끼리만 연산할 수 있다.
	 * 3. 같은 타입간 연산의 결과는 같은 타입이다.
	 * 
	 * 형변환
	 * 1. 자동형변환 : 크기가 작은 타입에서 큰 타입으로 자동형변환 된다.
	 *    byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
	 * 				 char(2)
	 * 
	 * 2. 명시적형변환 : 형변환코드가 필요
	 * 
	 */
	public void test1() {
//		int i = true;
		int a = 10;
		int b = 3;
		int result = a / b; // 몫을 구하는 연산
		System.out.println("result = " + result);
		
		int m = 10; // 10.0
		double n = 3.0;
		System.out.println(m / n); // int / double => double / double => double
		
		char ch = '가';
		int i = ch; // int = char => int = int
		System.out.println(i);
		
		System.out.println('A' + 100); // char + int => int + int =>  165
		System.out.println('0' + 52); // char + int => int(48) + int => 100
		
		System.out.println("A" + 52); // "A52" 
		System.out.println('0' + "0"); // char + String => String + String => "00" 
		System.out.println('0' + 0); // char + int => 48 + 0 => 48
		
		
		
	}
}






