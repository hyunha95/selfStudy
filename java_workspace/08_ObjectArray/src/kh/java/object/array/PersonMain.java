package kh.java.object.array;

public class PersonMain {

	public static void main(String[] args) {
		PersonMain main = new PersonMain();
//		main.test1();
//		main.test2();
//		main.test3();
		main.test4();
	}
	
	/**
	 * 관리자클래스를 통한 VO객체배열 관리
	 */
	public void test4() {
		PersonManager manager = new PersonManager();
		manager.inputPerson();
		manager.printPerson();
	}
	
	/**
	 * 1. 3명의 데이터를 관리할 수 있는 Person배열을 만들고, 사용자 입력값(이름/나이)를 통해서
	 * 각 Person객체를 생성하세요.
	 * 2. 평균나이 출력
	 */	
//	public void test3() {
//		Scanner sc = new Scanner(System.in);
//		Person[] arr = new Person[3];
//		int sum = 0;
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print("이름 : ");
//			String name = sc.next();
//			System.out.print("나이 : ");
//			int age = sc.nextInt();
//			arr[i] = new Person(name, age);
//			System.out.println("---------------");
//			sum += age;
//		}
//		for(Person p : arr)
//			System.out.println(p.getPersonInfo());
//		
//		double avg = (double) sum / arr.length;
//		System.out.printf("평균나이 : %.2f", avg);
//	}


	/**
	 * 객체배열 초기화
	 */	
//	public void test2() {
//		Person[] arr = {
//				new Person("장보고", 33),
//				new Person("유리", 20),
//				new Person("하리보", 8),
//		};
//		
////		Person[] arr = new Person[]{
////				new Person("장보고", 33),
////				new Person("유리", 20),
////				new Person("하리보", 8),
////		};
//		
//		for(Person p : arr) {
//			System.out.println(p.getPersonInfo());
//		}
//	}

//	public void test1() {
//		//배열 선언
//		Person[] arr;
//				
//		//배열 할당
//		arr = new Person[5];
//				
//		//배열 요소 할당
//		arr[0] = new Person("홍길동", 30);
//		arr[1] = new Person("유관순", 16);
//		arr[2] = new Person("세종대왕", 22);
//		arr[3] = new Person("이순신", 40);
//		arr[4] = new Person("장보고", 48);
//				
//		//열람
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] != null)
//			System.out.println(arr[i].getPersonInfo());
//		}
//	}
}
