package kh.java.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kh.java.collection.list.ArrayListStudy;
import kh.java.collection.list.ArrayListStudy.Student;

public class HashMapStudy {

	public static void main(String[] args) {
		HashMapStudy study = new HashMapStudy();
		study.test1();
//		study.test2();
//		study.test3();

	}

	/**
	 * VO객체 map으로 관리하기
	 * - key   : vo객체에서 고유한 값. 학생번호/회원아이디
	 * - value : vo객체
	 */
	private void test3() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "홍길동"));
		map.put(2, new Student(2, "세종대왕"));
		map.put(3, new Student(3, "유관순"));
		
		// map에 특정 key가 존재하는가
		System.out.println(map.containsKey(1));
		
		// map에 특정 value가 존재하는가
		System.out.println(map.containsValue(new Student(1, "홍길동")));
		
		// values 모음
		Collection<Student> values = map.values();
		System.out.println(values);
	}

	/**
	 * Map의 모든 요소 순차적으로 열람하기
	 * 1. keySet : key를 모아서 Set<k>으로 반환
	 * 2. entrySet : Map.Entry를 모아서 Set<Map.Entry>으로 반환
	 */
	private void test2() {
		Map<String, Double> map = new HashMap<>();
		map.put("honggd", 80.5);
		map.put("yoogs", 50.6);
		map.put("sejong", 99.5);
		
		// 1. keySet
//		Set<String> keySet = map.keySet();
		// a. forEach
//		for(String key : keySet) {
//			Double value = map.get(key);
//			System.out.println(key + " = " + value);
//		}
		// b. iterator
//		Iterator<String> iter = keySet.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			Double value = map.get(key);
//			System.out.println(key + " = " + value);
//		}
		
		// 2. entrySet : map 하나의 요소 타입(key, value) 
		Set<Entry<String, Double>> entrySet = map.entrySet();
		// a. forEach
//		for(Entry<String, Double> entry : entrySet) {
//			String key = entry.getKey();
//			Double value = entry.getValue();
//			System.out.println(key + " = " + value);
//		}
		// b. iterator
		Iterator<Entry<String, Double>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Entry<String, Double> entry = iter.next();
			String key = entry.getKey();
			Double value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

	/**
	 * Map
	 * - (key-value형식) 한쌍으로 저장된다.
	 * - key는 중복을 허용하지 않는다.
	 * - value는 중복될 수 있다.
	 * - 저장한 순서는 유지되지 않는다.
	 * - 동일한 key를 가진 요소를 추가하면, value를 대체한다.
	 * 		k1-v1가 존재할때, k1-v2를 추가하면, k1-v2로 대체된다.
	 * 
	 * 
	 */
	private void test1() {
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		Map<Integer, ArrayListStudy.Student> map2 = new HashMap<>();
		
		// 요소추가
		map1.put("honggd", 100);
		map1.put("sinsa", 75);
		map1.put("leess", 55);
		
		// key값이 중복된 요소추가
		Integer prev = map1.put("honggd", 88); //Returns the previous value associated with key,
		System.out.println("prev = " + prev);
		
		// key값으로 하나의 요소를 참조
		Integer v = map1.get("honggd");
		System.out.println(v);
		
		// key값으로 요소를 삭제
		map1.remove("sinsa");
		
		// 요소의 개수
		System.out.println("size = " + map1.size());
		
		// toString
		System.out.println(map1);
		
		Map<String, Integer> another = new HashMap<>();
		another.put("바나나", 3000);
		another.put("복숭아", 5000);
		
		// map을 통째로 추가
		map1.putAll(another);
		
		System.out.println(map1);
	}

}
