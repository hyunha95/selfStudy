package com.kh.jdk.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * 클래스객체를 통해서 클래스 정보를 분석하고,
 * 객체생성/메소드호출/필드값활용 등이 가능한 프로그래밍 기법
 *
 */
public class ReflectionAPIStudy {
	
	public static void main(String[] args) throws Exception {
		ReflectionAPIStudy study = new ReflectionAPIStudy();
		study.test1();
		study.test2();
	}

	/**
	 * 객체 생성
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void test2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clz = Sample.class;
		
		// 생성자
		Constructor<?>[] constructors = clz.getDeclaredConstructors();
		for(Constructor<?> constr : constructors) {
			System.out.println(constr);
		}
		
		// newInstance가 object를 리턴하기 때문에 형변환이 필요하다
		Sample inst1 = (Sample) constructors[0].newInstance(null);
		System.out.println(inst1);
		
		// newInstance안에는 생성자에 전달할 매개인자를 적는다.
		Sample inst2 = (Sample) constructors[1].newInstance(100, "안녕");
		System.out.println(inst2);
	}

	/**
	 * 클래스객체 가져오기
	 */
	private void test1() throws ClassNotFoundException {
		Class clz1 = Sample.class;
		Class clz2 = Class.forName("com.kh.jdk.reflection.Sample");
		
		System.out.println(clz1);
		System.out.println(clz2);
		
		System.out.println(clz1 == clz2);
		
	}
}
