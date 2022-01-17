package kh.java.variable;

public class PrimitiveTypeStudy {

	public static void main(String[] args) {
		
		PrimitiveTypeStudy study = new PrimitiveTypeStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
	}
	
	/**
	 * Data Overflow
	 * 
	 * 최대값의 범위를 넘어서면, 다시 최소값으로 돌아가는 현상
	 */
	public void test4() {
		int i = Integer.MAX_VALUE;
		
		i = i + 1;
		
		System.out.println("i = " + i);
		System.out.println(Integer.MIN_VALUE == i); //true
	}
	
	/**
	 *  상수 : 한번 값이 정해지면 바뀌지 않는 변수
	 *  final 키워드를 추가. 선언시에 바로 값대입(초기화)해야 한다.
	 */
	public void test3() {
		final int MAX_NUMBER = 100;
		System.out.println(MAX_NUMBER);
		
//		N = 200;
//		System.out.println(N);
	
		//기본형의 값의 범위를 지닌 상수
		System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
	}
	
	/**
	 * 초기화 : 변수 선언과 값대입을 동시에 처리
	 */
	public void test2() {
		int num = 1234;
		byte b = -100;
		
		char ch = 'x';
	}

	/**
	 * 변수 : 하나의 값을 보관할 수 있는 공간
	 * 
	 * 1. 선언
	 * 2. 값대입
	 * 3. 사용
	 * 
	 * 변수의 자료형
	 * 1. 기본형 - 실제 값을 저장
	 * 		논리형 boolean(1byte) true/false
	 * 		문자형 char(2byte) 'a' '가'  0~65535
	 * 		정수형 byte(1byte) -128 ~ 127
	 * 			 short(2byte) -32768 ~ 32767
	 * 			 int(4byte) -21억 ~ 21억 (기본형)
	 * 			 long(8byte) -922경 ~ 922경
	 * 		실수형 float(4byte) 정밀도 숫자부분 7자리 표현
	 *			  double(8byte) 숫자부분 16자리 표현 (기본형)
	 * 
	 * 2. 참조형 - 주소값을 저장, 기본형 8개를 제외한 모든 타입. 4byte로 고정
	 */
	public void test1() {
		// 1. 선언
		byte bnum;
		short $h;
		int i;
		long l_num;
		
		float fnum;
		double dnum;
		
		boolean bool;
		char ch;
		
		char 한글; //변수명 한글 가능. 하지만 쓰지 말것.
		// 2. 값대입
		bnum = 100;
		$h = 10000;
		i = 999;
		l_num = 999_999_999_999_999L; // long타입의 값은 접미사L을 붙인다.
		
		fnum = 0.123456789f; // float 타입값을 접미사 F/f로 명시한다.
		dnum = 0.12345678901234567890;
		
		bool = false;
		ch = '갓';
		
		//3. 사용
		System.out.println(bnum);
		System.out.println($h);
		System.out.println(i);
		System.out.println(l_num);
		System.out.println(fnum);
		System.out.println(dnum);
		System.out.println(bool);
		System.out.println(ch);
	}
}
