package kh.java.oop.constructor;

import java.util.Date;

public class UserMain {

	public static void main(String[] args) {
		// 기본생성자 + setter 필드값 설정
		User u1 = new User(); // 기본생성자 호출!
		u1.setId("honggd");
		u1.setPassword("1234");
		u1.setRegDate(new Date());
		u1.printUser();
		
		//2. 파라미터생성자 : 객체생성시에 필드값 설정
		User u2 = new User("sinsa", "1234", new Date());
		u2.printUser();
		
		User u3 = new User("leess", "1234");
		u3.printUser();
	}

}
