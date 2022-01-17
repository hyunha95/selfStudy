/*
 [객체실습]
 - 도서정보 관리용 클래스 만들기
 - 클래스명 : com.oop.book.model.Book.java
 - 멤버변수 : 반드시 캡슐화를 적용할 것
	- title:String	//책제목
	- price:int	//가격
	- discountRate:double	//할인율
	- author:String	//저자명
 - 기본(default) 생성자와 4개의 필드를 초기화하는 매개변수가 있는 생성자 작성함
 - 출력용 메소드 작성함 : 객체가 가진 필드값 화면 출력 처리
	public void bookInfomation()
 - 테스트용 클래스 : com.oop.book.controller.TestBook.java
	main() 메소드 포함
 - main() 에서
	1. Book 클래스에 대한 객체를 디폴트 생성자를 사용해서 생성함
	2. 매개변수 있는 생성자를 사용해서 두번째 객체 생성함
	3. 2개의 객체가 가진 정보를 화면출력함
	<출력예>
	null	0	0.0	null
//2단계 --------------------------------------------------------------------------------
 - Book 클래스에 setter 추가함 : 4개의 필드에 대한 setter 메소드 작성함
 - TestBook 클래스의 main() 메소드 안의 기존의 소스코드 아래에 추가함
	1. 첫번째 객체가 가진 값을 setter 를 사용해서 수정
	2. 출력확인함
	<출력예>
	null	0	0.0	null
	뇌를 자극하는 JAVA	20000	0.2	김윤영
	수정된 결과확인
	자바의 정석     35000  0.1   윤상섭
//3단계 ------------------------------------------------------------------------------
 - Book 클래스에 getter 추가함 : 4개의 필드에 대한 getter 모두 작성
 - TestBook 클래스의 main() 메소드에 소스 추가함
	1. 두 객체 각각 할인율을 적용한 책 가격을 계산해서 출력함
	할인된 가격 = 가격 - (가격 * 할인율);
	<출력결과>
	도서명 : 자바의 정석
	할인된 가격 : 31500 원
	도서명 : 뇌를 자극하는 자바
	할인된 가격 : 16000 원
 */

package com.oop.book.controller;

import com.oop.book.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setTitle("자바의 정석");
		b1.setPrice(35000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("윤상섭");
	
		
		Book b2 = new Book("뇌를 자극하는 Java", 20000, 0.2, "김윤영");
		
		b1.bookInformation();
		b2.bookInformation();
		
		System.out.println("도서명 : " + b1.getTitle());
		System.out.println("할인된 가격 : " + (int)(b1.getPrice() - (b1.getDiscountRate() * b1.getPrice())) + "원");
		System.out.println("도서명 : " + b2.getTitle());
		System.out.println("할인된 가격 : " + (int)(b2.getPrice() - (b2.getDiscountRate() * b2.getPrice())) + "원");
		
		

	}

}
