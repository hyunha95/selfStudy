/*
[객체실습 3]
 - 상품 관리용 클래스 만들기
	클래스명 : com.oop.product.model.Product.java
 - Field 구성 : 반드시 enCapsulation 할 것
	- productID:String		//상품아이디
	- productName:String	//상품명
	- productArea:String	//생산지
	- price:int				//가격
	- tex:double			//부가세비율
 - Constructor 만들기
	기본생성자
	5개의 필드 초기화하는 매개변수 있는 생성자
 - Method 만들기
	public void information()
	//객체가 가진 5개의 필드값 출력하는 메소드
 - 테스트용 클래스 만들기
	클래스명 : com.oop.product.controller.TestProduct.java
	//main() 메소드 포함
 - main() 에서 구현함
	1. 매개변수 있는 생성자를 사용해서 3개의 객체를 생성함
	2. 객체가 가진 필드값 출력확인
	<출력예>
	ssgnote6	  갤럭시노트6  경기도수원  960000  10.0
	lgxnote5	  LG스마트폰5  경기도평택  780000  0.7
	ktnorm3	  KT일반폰3   서울시강남  25000  0.3
//2단계 ------------------------------------------------------------------
 - Product 클래스에 각 필드에 대한 setter 추가함
 - TestProduct 클래스의 main() 에서
	1. 각 객체의 가격을 모두 120만원으로 변경함
	2. 각 객체의 부가세율도 모두 0.05로 수정함
	3. 결과 확인
//3단계 ------------------------------------------------------------------
 - Product 클래스에 각 필드에 대한 getter 추가함
 - TestProduct 클래스의 main() 에 소스 추가 작성함
	1. 부가세율을 모두 0.05로 수정함
	2. 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산해서 출력함
	실제 가격 = 가격 + (가격 * 부가세율);
	<출력결과>
	상품명 : 갤럭시노트6
	부가세 포함 가격 : 1260000 원
	상품명 : LG스마트폰5
	부가세 포함 가격 : 1260000 원
	상품명 : KT일반폰3
	부가세 포함 가격 : 1260000 원
 */

package com.oop.product.controller;

import com.oop.product.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		Product p1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
		Product p2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
		Product p3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
		
		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);
		
		p1.setTax(0.05);
		p2.setTax(0.05);
		p3.setTax(0.05);
		
		p1.information();
		p2.information();
		p3.information();
		
		System.out.println("상품명 : " + p1.getProductName());
		System.out.println("부가세 포함 가격 : " + (int)(p1.getPrice() + (p1.getPrice() * p1.getTax())));
		
		System.out.println("상품명 : " + p2.getProductName());
		System.out.println("부가세 포함 가격 : " + (int)(p2.getPrice() + (p2.getPrice() * p2.getTax())));
				
		System.out.println("상품명 : " + p3.getProductName());
		System.out.println("부가세 포함 가격 : " + (int)(p3.getPrice() + (p3.getPrice() * p3.getTax())));

	}

}
