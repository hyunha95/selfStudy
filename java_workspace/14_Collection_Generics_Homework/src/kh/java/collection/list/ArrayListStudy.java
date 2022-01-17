package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ArrayListStudy {

	public static void main(String[] args) {
		ArrayListStudy study = new ArrayListStudy();
//		study.test0();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
//		study.test6();
		study.test7();
	}
	
	
	/**
	 * 커스텀클래스 Student의 정렬
	 * - no asc 기본정렬 Comparable구현
	 * - no desc Comparator구현
	 * - name asc Comparator구현
	 * - name desc Comparator구현
	 */
	private void test7() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(300, "장보고"));
		list.add(new Student(500, "이을용"));
		list.add(new Student(200, "세종대왕"));
		list.add(new Student(100, "홍길동"));
		list.add(new Student(400, "논개"));
		
		// 기본정렬 : no asc
//		list.sort(null);
		// 그외 정렬  기본정렬 역순 : no desc
//		list.sort(Collections.reverseOrder());
		
		// 그외 정렬 : name asc
//		list.sort(new StudentNameAsc());

		// 그외 정렬 : name desc
		list.sort(Collections.reverseOrder(new StudentNameAsc()));
		
		
		System.out.println(list);
	}



	/**
	 * List의 정렬 (순서유지) sort 오름차순정렬
	 * - Comparable인터페이스 구현 : 기본정렬(오름차순) 1개 -> 해당클래스에서 직접 구현(compareTo)
	 * - Comparator인터페이스 구현 : 추가정렬방식 n개 -> 별도의 인터페이스구현클래스 작성(compare)
	 * 
	 */
	private void test6() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(4);
		
		// 요소가 가진 기본정렬(오름차순)
		list.sort(null); // 정렬기준객체 Comparator null 전달
		
		// 내림차순
		Comparator<Integer> comp = Collections.reverseOrder(); // 기본정렬의 역순
		list.sort(comp);
		
		System.out.println(list);
		
		
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("고명보");
		names.add("눈누난파");
		names.add("당진영");
		names.add("라현희");
		
		// 기본정렬 가나다순
//		names.sort(null);
		
		// 기본외 정렬 다나가순
		names.sort(Collections.reverseOrder());
		
		System.out.println(names);
	}



	/**
	 * List를 활용해서 Student객체 관리
	 */
	private void test5() {
		List<Student> list = new ArrayList<>();
		// 학생 3명 정보
		list.add(new Student(100, "홍길동"));
		list.add(new Student(200, "세종대왕"));
		list.add(new Student(300, "장보고"));

		// 학생정보 2명 추가
		list.add(new Student(400, "논개"));
		list.add(new Student(500, "이을용"));

		// 장보고 학생 전학감(제거)
//		list.remove(2);
		for(int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if("장보고".equals(s.getName())) {
				list.remove(i);
			}
		}
		
		// ConcurrentModificationException 발생
//		for(Student s: list)
//			if("장보고".equals(s.getName())) {
//				list.remove(s);
//			}
		
		// 박지성학생 전학옴 : 2번지 추가
		list.add(2, new Student(999, "박지성"));
		
		for(int i = 0; i < list.size(); i++)
			System.out.printf("%d : %s%n", i, list.get(i));
	}

	/**
	 * 요소를 열람
	 * 1. for - index
	 * 2. forEach
	 * 3. Iterator객체
	 * 
	 */
	private void test4() {
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("홍명보");
		names.add("홍난파");
		names.add("홍진영");
		names.add("홍현희");
		
		// 1. for loop
//		for(int i = 0; i < names.size(); i++) {
//			String name = names.get(i);
//			System.out.println(i + " : " + name);
//		}
		
		// 2. forEach
//		for(String name : names) {
//			System.out.println(name);
//		}
		
		// 3. iterator
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
	}

	/**
	 * List API
	 */
	private void test3() {
		List<Double> list = new ArrayList<Double>();
		
		// 맨 뒤에 요소를 추가
		list.add(1.234);
		list.add(3.1);
		list.add(4.56);
		list.add(3.1);
		
		// 중간에 요소 추가
		list.add(1, 8.88);
		
		// 요소 대체
		list.set(1, 7.77);
		
		// 요소 제거 - 인덱스
		list.remove(1);
		
		// 요소 제거 - 값
//		list.remove(3.1);
		
		// 해당요소가 존재하는가 
		boolean bool = list.contains(3.1);
		System.out.println(bool);
		
		// 요소의 인덱스를 반환
//		int idx = list.indexOf(3.1);
		int idx = list.lastIndexOf(3.1);

		System.out.println(idx);
		System.out.println(idx > -1); // 존재여부
		
		// 기존 List의 요소를 추가
		List<Double> other = new ArrayList<>();
		other.add(1.0);
		other.add(2.0);
		other.add(3.0);
		// Collection타입으로 추가 : list, set객체 추가 가능
//		list.addAll(other);
		list.addAll(0, other);
		
		// 전체요소 삭제
		list.clear();
		
		// 빈 리스트인가
		System.out.println("isEmpty : "  + list.isEmpty());
		
		System.out.println(list);
		
 	}

	/**
	 * Generics 타입제한
	 * 
	 * List<String>
	 * - String 타입의 요소만 추가할수 있다.
	 * - getter의 리턴타입은 String이다.
	 * - 기본형은 사용할 수 없다.
	 * 
	 */
	public void test2() {
		// 우항의 generic은 생략이 가능하다.(1.7)
		List<String> list = new ArrayList<>();
		list.add("안녕");
		list.add(new String("hello world"));
//		list.add(new Student()); // 타입의 컴파일타임 체크가 가능하다.
		
		String elem0 = list.get(0);
		System.out.println(elem0);
		
		// Wrapper클래스를 통해서 기본형도 관리할 수 있다.
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(3); // int -> Integer : auto-boxing
		intList.add(Integer.valueOf(3));
		
		int n = intList.get(0); // Ingeger -> int : auto-unboxing 
		// int n = intList.get(0).intValue();
		
	}

	/**
	 * List인터페이스 - ArrayList : 배열 - LinkedList : Node객체 - Node객체 - Node객체
	 */
	private void test1() {
		ArrayList list1 = new ArrayList();
		List<Object> list2 = new ArrayList<Object>();
		Collection list3 = new ArrayList();

		// 요소추가 : 저장한 순서를 유지한다.
		list2.add("abc");
		list2.add(true);
		list2.add(123);
		list2.add(67.89);
		list2.add(new Date());
		list2.add(new Student(111, "홍길동"));

		// get(int) 인덱스를 통해서 가져오기
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		System.out.println(list2.get(2));
		
		Object elem0 = list2.get(0);

		// 전체 요소의 개수
		System.out.println(list2.size());

		// 반복문
		for(int i = 0; i < list2.size(); i++)
			System.out.println(i + " : " + list2.get(i));

		// toString
		System.out.println(list2);
	}

	/**
	 * Student객체를 관리 - Student[]
	 */
	private void test0() {

		Student[] arr = new Student[3];
		arr[0] = new Student(100, "홍길동");
		arr[1] = new Student(200, "세종대왕");
		arr[2] = new Student(300, "장보고");

		// 학생정보 2명 추가
		Student[] newArr = new Student[10]; // 나중에 또 부족하지 않도록 크기를 미리 키워둠(메모리 낭비)
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[3] = new Student(400, "논개");
		newArr[4] = new Student(500, "이을용");

		// 장보고 학생 전학(제거)
		newArr[2] = newArr[3];
		newArr[3] = newArr[4];
		newArr[4] = null;

		// 박지성학생 전학 : 2번지 추가
		newArr[4] = newArr[3];
		newArr[3] = newArr[2];
		newArr[2] = new Student(999, "박지성");

		for (int i = 0; i < newArr.length; i++)
			System.out.println(i + " : " + newArr[i]);
	}
	
	static class StudentNameAsc implements Comparator<Student> {
		
		/**
		 * name필드값 비교
		 * - s1.name < s2.name : -1
		 * - s1.name = s2.name : 0
		 * - s1.name > s2.name : 1
		 * 
		 *  name:String의 기본 비교연산 compareTo
		 */
		@Override
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
	}
	

	/**
	 * 
	 * 내부클래스
	 *
	 */
	public static class Student implements Comparable<Student> {
		private int no;
		private String name;

		public Student() {
		}

		public Student(int no, String name) {
			super();
			this.no = no;
			this.name = name;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * equals 연산에 사용한 필드를 기준으로 hash값을 새로 생성해야 한다.
		 */
		@Override
		public int hashCode() {
			return Objects.hash(no, name);
		}
		
		/**
		 * equals의 결과가 true라면 동일한 hashCode값을 가져야 한다.
		 */
		@Override
		public boolean equals(Object other) {
			if(this == other)
				return true;
			
			if(!(other instanceof Student))
				return false;
			
			Student otherStudent = (Student) other;
			// 필드값 no 비교
			if(this.no != otherStudent.no)
				return false;
			
			// 필드값 name 비교
			if(!this.name.equals(otherStudent.name))
				return false;
			
			return true;
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", name=" + name + "]";
		}
		
		/**
		 * 기본 정렬기준 컬럼 no
		 * - 음수 : this.no < other.no
		 * - 0 : this.no == other.no
		 * - 양수 : this.no > other.no
		 * 
		 */
		@Override
		public int compareTo(Student other) {
			return this.no - other.no;
		}

	}
}
