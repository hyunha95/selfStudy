package com.kh.test;

/*
 	자신의 신상정보를 저장할 변수를 만들고 정보를 변수에 대입, 출력하는 프로그램을 작성하세요.
 	- 이름, 나이, 성별,주소, 전화번호, 이메일      

	작성한 변수를 활용해 옆 친구의 신상정보를 다시 변수에 대입 출력하는 프로그램으로 수정하세요.
 */
public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}

	private void test() {
		String name = "홍두깨";
		int age = 22;
		String addr = "서울";
		String gender = "남";
		String phone = "01012345678";
		String email = "myemail@email.com";
		
		String line = "------------------------------------------------------------------------------------------------------------";
		
		System.out.println(line);
		//printf메소드에서 탭은 \t이다. %t아님. 
		//단, \n도 사용가능하지만, %n이 운영체제에 맞는 개행문자로 치환되므로, %n을 사용하자.
		System.out.printf("%10s%10s%10s%20s%20s%30s%n","이름", "나이", "성별", "전화번호", "이메일", "주소");
		System.out.println(line);
		System.out.printf("%10s%10s%10s%20s%20s%30s%n",name, age, gender,  phone, email, addr);
		
		
		//친구신상정보를 선언한 변수에 담고, 동일하게 출력하기
		
		name = "고길동";
		age = 50;
		addr = "경기도";
		gender = "남";
		phone = "01098765432";
		email = "mrgogo@email.com";
		
		System.out.println(line);
		System.out.printf("%10s%10s%10s%20s%20s%30s%n",name, age, gender,  phone, email, addr);
		
		
	}

}
