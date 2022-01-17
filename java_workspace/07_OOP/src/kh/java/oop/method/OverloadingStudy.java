package kh.java.oop.method;

/**
 * Method Overloading
 * - 한 클래스내에서 메소드이름이 같고, 파라미터선언부가 다른 메소드를 여러개 정의하는 것
 * 
 * 조건
 * - 메소드명 같아야 한다.
 * - 매개변수 선언부는 어떻게든 달라야 한다. (개수, 타입, 순서)
 * 
 * 주의점
 * - 매개변수명, 접근제한자, 리턴타입은 상관치 않는다.
 * 
 * 동일한 기능을 수행하되, 매개인자 타입이 다른 경우 오버로딩을 처리하기 적합하다.
 * 
 */

public class OverloadingStudy {

	public static void main(String[] args) {
		OverloadingStudy study = new OverloadingStudy();

//		study.foo();
//		study.foo(1, 2);
		study.foo(1000L, "안녕");
//		study.foo(100, "안녕", "잘가", "바이바이");
	}
	
	public void foo() {}
	public void foo(int a) {}
	public void foo(int a, int b) {}
//	public void foo(int b, int a) {}
	
	public void foo(int a, String s) {
		System.out.println("foo(int a, String s)");
	}
	public void foo(int a, String... s) {
		System.out.println("foo(int a, String... s)");
	}
//	public void foo(int a, String[] s) {}
//	private void foo(int a, String s) {}
	public String foo(long a, String s) {
		System.out.println("foo(long a, String s)");
		return "abcde";
	}
	public void foo(int a, String s, char c) {}
	public void foo(int a, String s, char c, double d) {}
}
