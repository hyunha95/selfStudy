package kh.java.collection.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kh.java.collection.list.ArrayListStudy;
import kh.java.collection.list.ArrayListStudy.Student;

public class HashSetStudy {

	public static void main(String[] args) {
		HashSetStudy study = new HashSetStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
//		study.test6();

	}

	/**
	 * LinkedHashSet : 중복허용안함. 저장순서 유지
	 * TreeSet : 중복허용안함. 요소의 기본정렬 지원
	 */
	private void test6() {
		Set<ArrayListStudy.Student> set1 = new LinkedHashSet<>();
		set1.add(new Student(2, "홍진영"));
		set1.add(new Student(3, "홍현희"));
		set1.add(new Student(1, "홍길동"));
		System.out.println(set1);
		
		Set<ArrayListStudy.Student> set2 = new TreeSet<>(set1);
		System.out.println(set2);
	}

	/**
	 * 커스텀클래스의 Set으로 관리하기
	 * - 동등성비교(필드의 내용으로 객체의 같음을 판단)할 수 있도록 equals, hashCode override해야 한다.
	 */
	private void test5() {
		Set<ArrayListStudy.Student> set = new HashSet<>();//외부클래스.내부클래스
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "홍진영"));
		set.add(new Student(3, "홍현희"));
		set.add(new Student(1, "홍길동"));
		
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(set);
		
	}

	/**
	 * 1 ~ 45 사이의 중복 없는 난수 6개
	 * 
	 * 오름차순 정렬 출력
	 */
	private void test4() {
		Set<Integer> lotto = new HashSet<Integer>();
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);
		
		List<Integer> lottoList = new ArrayList<>(lotto);
		lottoList.sort(null); // 요소 Integer가 구현한 기본정렬(Comparable)을 사용
		System.out.println(lottoList);
	}

	/**
	 * 
	 * List -> Set : 중복제거
	 * Set -> List : 인덱스관련 기능, 정렬
	 * 
	 */
	private void test3() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		
		System.out.println(list.size());
		System.out.println(list);
		
		// Set으로 변환
		// new HashSet(Collection<Integer>)
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set.size());
		System.out.println(set);
		
		
		// 다시 list로 변환
		List<Integer> anotherList = new ArrayList<>(set);
		System.out.println(anotherList.get(0));
		anotherList.sort(Collections.reverseOrder()); // 역순 정렬
		System.out.println(anotherList);
		
	}

	/**
	 * 전체요소 열람
	 * 1. iterator객체
	 * 2. forEach문
	 */
	private void test2() {
		Set<String> nameSet = new HashSet<>();
		nameSet.add("강호동");
		nameSet.add("홍길동");
		nameSet.add("강만옥");
		nameSet.add("강남길");
		nameSet.add("강남");
		
		
		// 1. iterator객체
//		Iterator<String> iter = nameSet.iterator();
//		while(iter.hasNext()) {
//			String name = iter.next();
//			System.out.println(name);
//		}
		// 2. forEach
		for(String name : nameSet) {
			System.out.println(name);
		}
	}

	/**
	 * Set 
	 * 중복저장을 허용하지 않는다.
	 * 저장순서를 기억하지 않는다.
	 * 
	 * - HashSet
	 * - LinkedHashSet 저장순서를 기억한다.
	 * - TreeSet 오름차순 정렬 지원한다.
	 */
	private void test1() {
		HashSet<String> set1 = new HashSet<String>();
		Set<Integer> set2 = new HashSet<Integer>();
		Collection<Character> set3 = new HashSet<Character>();
		
		// 요소추가
		set2.add(123);
		set2.add(4);
		set2.add(666);
		set2.add(23);
		System.out.println(set2.add(1)); // add:boolean 이미 요소를 가지고 있지 않다면 true 리턴
		System.out.println(set2.add(23));
		
		// 요소개수 확인
		System.out.println(set2.size());
		
		// 요소 포함 여부
		System.out.println(set2.contains(123));
		
		// 요소 삭제 : 해당요소를 전달해서 삭제
		System.out.println(set2.remove(666));
		
		// 전체요소 삭제
		set2.clear();
		
		// set이 비었는가
		System.out.println(set2.isEmpty());
		
		// toString : 요소확인
		System.out.println(set2);	
	}

}
