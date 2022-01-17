package kh.java.inherit.product;

import java.util.Date;

public class ProductMain {

	public static void main(String[] args) {
		
		// 파라미터생성자를 이용해 Desktop객체 생성
		Desktop desktop = 
				new Desktop("삼성", "samsung-123456", "삼성올인원데스크탑", 2000000, new Date(),
						    "windows10", "32인치UHD", "기계식키보드", "무선마우스");
		System.out.println(desktop.productInfo());
		
		SmartPhone smartPhone = 
				new SmartPhone("Apple", "Iphone-12", "아이폰12", 1500000, new Date(),
								"iOS14", "01012341234", "SKT");
		System.out.println(smartPhone.productInfo());
				
		Tv tv = new Tv("LG", "lg-curved-1234", "엘지커브드TV", 3000000, new Date(), 
					   "UHD", 100);
		System.out.println(tv.productInfo());
	}

}
