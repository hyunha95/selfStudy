package kh.java.variable;

	public class StringStudy {

	/**
	 * "안녕하세요"
	 * 
	 * String은 기본형이 아닌 참조형이다.
	 * 
	 * 기본형처럼 리터럴(값) 대입이 허용된다.
	 * 
	 */
	public static void main(String[] args) {
		String s = new String("안녕");
		System.out.println(s);
		
		String s1 = "안녕";
		System.out.println(s1);
		
		//더하기 연산
		System.out.println(s + s1 + 12345);
		
		System.out.println("ab" + ('c' + 123)); //String + (char + int) => String + int
	}
}
