package kh.java.oop.init.block;

/**
 * 멤버변수의 초기화 과정
 * 1. 타입별 기본값
 * 2. 명시한 값
 * 3. 초기화블럭에서 대입한 값
 * 4. 생성자메소드에서 대입한 값
 *
 * 클래스변수의 초기화과정
 * 1. 타입별 기본값
 * 2. 명시한 값
 * 3. 초기화블럭에서 대입한 값
 * 
 */
public class Sample {
	static int snum = 55;
	int num = 100;
	
	//클래스변수용 초기화블럭
	static{
		System.out.println("static초기화 블럭전 snum = " + snum) ;
		snum = 66;
		
	}
	
	//멤버변수용 초기화 블럭
	//초기화블럭안에서는 실행코드를 작성할 수 있다.
	//객체 생성할 때 자동으로 실행됨.
	{
		System.out.println("초기화 블럭 전 num = " + num);
		num = 200;
	}
	
	public Sample() {
		System.out.println("생성자 실행 전 num = " + num);
		num = 300;
	}
}
