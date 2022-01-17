package kh.java.oop.method;

public class MethodStudy {
	
	static int snum = 100;	//클래수 변수
	int num = 99;	// 멤버변수
	
	/**
	 * static메소드는 non-static자원(필드, 메소드)를 직접 참조할 수 없다.
	 * non-static메소드는 static자원, non-static자원을 모두 사용할 수 있다.
	 */

	public static void main(String[] args) {
		System.out.println(snum);
//		System.out.println(num); //Cannot make a static reference to the non-static field num
		
		MethodStudy study = new MethodStudy();
		study.foo();
		
	}
	/**
	 * this : 현재객체를 가리키는 참조변수. 
	 * 			non-static메소드안에만 존재
	 */
	public void foo() {
		System.out.println(this);
		System.out.println("foo");
		System.out.println(snum);
		System.out.println(num);
		
		//static 메소드 호출가능
		MethodStudy.bar();
	}
	
	/**
	 * this를 사용할 수 없다.
	 */
	public static void bar() {
//		System.out.println(this);
		System.out.println("bar");
		
		System.out.println(snum);
//		System.out.println(num);
		
		//non-static메소드 호출 불가능
//		foo();
		//객체생성 후 객체를 통해 non-static호출이 가능
//		new MethodStudy().foo();
		
	}

}
