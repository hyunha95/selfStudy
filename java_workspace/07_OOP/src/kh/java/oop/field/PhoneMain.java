package kh.java.oop.field;

public class PhoneMain {

	public static void main(String[] args) {
		IPhone12 hongPhone = new IPhone12();
		hongPhone.setName("홍길동");
		hongPhone.setTel("01012341234");
		System.out.println("이름 : " + hongPhone.getName());
		System.out.println("전화번호 : " + hongPhone.getTel());
//		IPhone12.WIDTH = 8;
//		IPhone12.HEIGHT = 17;
		System.out.println(IPhone12.WIDTH);
		System.out.println(IPhone12.HEIGHT);
		
		IPhone12 sinsaPhone = new IPhone12();
		sinsaPhone.setName("신사임당");
		sinsaPhone.setTel("01056785678");
		System.out.println("이름 : " + sinsaPhone.getName());
		System.out.println("전화번호 : " + sinsaPhone.getTel());
		System.out.println(IPhone12.WIDTH);
		System.out.println(IPhone12.HEIGHT);
		
		
		IPhone12 hyunhaPhone = new IPhone12();
		hyunhaPhone.setName("노현하");
		hyunhaPhone.setTel("01011112222");
		System.out.println("이름 : " + hyunhaPhone.getName());
		System.out.println("전화번호 : " + hyunhaPhone.getTel());
		
		
		//전화걸기
		hongPhone.call(sinsaPhone.getTel());
		hyunhaPhone.call(hongPhone.getTel());
	}

}
