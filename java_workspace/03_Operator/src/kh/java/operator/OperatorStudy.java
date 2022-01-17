package kh.java.operator;

import java.util.Scanner;

public class OperatorStudy {

	public static void main(String[] args) {
		OperatorStudy study = new OperatorStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	/**
	 * 산술대입연산자
	 * 
	 */
	public void test5() {
		int i = 10;
//		i = i + 5;
		i += 5 ;
		
//		i = i - 3;
		i -= 3;
		
//		i = i * 2;
		i *= 2;
		
//		i = i / 5;
		i /= 5;
		
//		i = i % 3;
		i %= 3;
		
		System.out.println("i = " + i);
	}
	
	/**
	 * 삼항연산자
	 * (조건식) ? (참일때 사용할 값) : (거짓일때 사용할 값);
	 * 
	 */
	public void test4() {
		int a = 10;
		int b = 20;
		int max = a > b ? a : b;
		System.out.println("max = " + max);
		
		System.out.println(a == b ? 0 : 1);
		
		// 짝홀수 여부
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int num = sc.nextInt();
		String result = num % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result + "를 입력하셨습니다.");
		
		// 연달아 쓰기
		result = a > b ? "a가 큽니다" : (a == b ? "a와 b는 같습니다." : "b가 큽니다.");
		System.out.println(result);
	}
	
	/**
	 * 이항연산자
	 * && AND a && b -> a가 참이면서 b도 참인가?
	 * || OR a || b -> a 또는 b가 참인가?
	 */
	public void test3() {
		int i = 10;
		int j = 11;
		// &&
		boolean bool;
		bool = (i > 0) && (i != j);
		bool = (i / j == 0) && (i - j < 0);
		bool = (i++ < j) && (i == j);

		// ||
		bool = (i == 0) || (j > 0); // false || true
		bool = (i == 11) || (i == 10); // true || false
		bool = (i++ == 11) || (i == 12); // true || true
		
		System.out.println(bool);
		
		int a = 1;
		int b = 1;
//		System.out.println(a > 0 && --b == 0);
//		System.out.println(a == 0 && --b == 0); // 우항 검사하지 않음 그러므로 b == 1
//		System.out.println(a == 0 & --b == 0); // & AND연산은 좌항의 결과와 상관없이 우항을 검사한다. 알고만 있고 두개짜리로 쓴다.
		
//		System.out.println(a - b != 0 || --b == 0);
//		System.out.println(a - b == 0 || --b == 0); //좌항이 참이면 우항은 연산하지 않음
//		System.out.println(a - b == 0 | --b == 0); // | OR연산은 좌항의 결과와 상관없이 우항을 검사한다. 알고만 있고 두개짜리로 쓴다.
		
		System.out.println(a - b == 0 || a >= b && a == b);
//		System.out.println((a - b) == 0 || (a >= b && a == b));
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
	
	/**
	 * 이항연산자
	 */
	public void test2() {
		int a = 30;
		int b = 20;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b); // 나머지연산
		
		boolean bool;
		
		bool = a == b;
		System.out.println(bool);
		
		bool = a != b; // a와 b가 같지 않아야 true, 같으면 false
		System.out.println(bool);
		
		bool = a > b; // 크다 gt greater than
		System.out.println(bool);
		
		bool = a < b; // 작다 lt less than
		System.out.println(bool);
		
		bool = a >= b; // 크거나 같다 ge greater than or equal to
		System.out.println(bool);

		bool = a <= b; //작거나 같다 le less than or equal to
		System.out.println(bool);
	}
	
	/**
	 * 단항연산자
	 */
	public void test1() {
//		int i = +9;
//		int j = -9;
//		boolean bool = false;
//		System.out.println(!!bool);
//		double d = 3.7;
//		System.out.println((int) d);
		
		// 증감연산자
		// 전위 증감연산자  ++a --a : 먼저 증감처리 후 인접연산에 사용된다.
		// 후위 증감연산자  a++ a-- : 인접연산에 사용된 후 증감처리한다.
//		int a = 10;
//		a--;
//		--a; // 단독으로 사용되는 경우는 인접연산이 없으므로, 전위/후위의 결과가 동일하다.
//		System.out.println("a = " + a);
		
		int m = 5;
		int n = m++;
//		System.out.println(++m + n);
		System.out.println("m = " + m);
		System.out.println("n = " + n);
		
		int k = 10;
		int h = 20;
		int z = k++ + --h;
		System.out.println("k = " + k);
		System.out.println("h = " + h);
		System.out.println("z = " + z);
		
		
		int q = 10;
		int w = 10;
		int e = ++q;
		System.out.println("e = " + e);
		System.out.println("q = " + q);

		e = w++;
		System.out.println("e = " + e);
		System.out.println("w = " + w);
		
		q = 20;
		e = q++ + --w;
		System.out.println("q = " + q);
		System.out.println("w = " + w);
		System.out.println("e = " + e);
	}
}










