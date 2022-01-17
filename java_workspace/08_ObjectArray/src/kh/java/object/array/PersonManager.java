package kh.java.object.array;

import java.util.Scanner;

/**
 *  has-a 포함관계(연관관계)
 * - PersonManager는 Person을 가지고 있다.
 * - PersonManager has a Person.
 */
public class PersonManager {
	
	public static final int MAX_PERSON = 100;
	private Person[] arr = new Person[MAX_PERSON];
	private int p = 0; // arr에 입력할 다음 Person객체의 index & 지금까지 입력한 Person객체
	Scanner sc = new Scanner(System.in);

	/**
	 * 사용자 입력으로 Person객체를 생성, Person배열에 할당
	 */
	public void inputPerson() {
		System.out.println("인물정보를 입력하세요");
		for( ; ; ) {
			Person person = new Person();
			System.out.print("이름 : ");
			person.setName(sc.next());
			System.out.print("나이 : ");
			person.setAge(sc.nextInt());
			
			//배열 할당
			arr[p++] = person;
			
			System.out.print("더 입력하시겠습니까? (y/n) : ");
			char yn = sc.next().charAt(0);
			if(yn == 'n') {
				break;
			}
		}
		System.out.println("인물정보 입력 끝!");
		
	}
	
	/**
	 * Person배열의 요소를 반복문을 통해 열람 - Person객체 정보 출력
	 */
	public void printPerson() {
//		for(Person p : arr) {
//			if(p != null)
//				System.out.println(p.getPersonInfo());			
//		}
		
//		for(Person p : arr) {
//			if(p == null)
//				break;
//			System.out.println(p.getPersonInfo());
//		}
		
		// 지금까지 입력한 Person객체의 개수
		for(int i = 0; i < p; i++) {
			System.out.println(arr[i].getPersonInfo());
		}
	}
}
