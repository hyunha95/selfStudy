package kh.java.collection.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesStudy {

	public static void main(String[] args) {
		PropertiesStudy study = new PropertiesStudy();
//		study.test1();
		study.test2();
//		study.test3();

	}

	private void test3() {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/config.properties"));
			Set<String> keySet = prop.stringPropertyNames();
			for(String key : keySet) {
				String value = prop.getProperty(key);
				System.out.println(key + " = " + value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void test2() {
		Properties prop = new Properties();
		
		try {
//			prop.load(new FileReader("login.properties"));
			prop.loadFromXML(new FileInputStream("login.xml"));
			
			System.out.println(prop);
			
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			
			// 전체요소 열람
			//1. keySet
			Set<String> keySet = prop.stringPropertyNames();
			for(String key : keySet) {
				String value = prop.getProperty(key);
				System.out.println(key + " = " + value);				
			}
			
			// 2. Enumeration 열거형객체를 이용한 순회
			Enumeration<?> enumer = prop.propertyNames();
			while(enumer.hasMoreElements()) {
				Object obj = enumer.nextElement();
				String key = (String) obj;
				String value = prop.getProperty(key);
				System.out.println(key + " = " + value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * java.util.Properties
	 * Key = String, Value = String으로 타입이 이미 지정된 map계열의 클래스
	 * 환경설정, 속성정보 등을 관리하는데 최적화된 컬렉션
	 * 파일추출 혹은 파일내용을 읽어들이는 기능지원
	 * 
	 */
	private void test1() {
		
		Properties prop = new Properties();
		prop.setProperty("url", "https://www.naver.com");
		prop.setProperty("username", "honggd");
		prop.setProperty("password", "1234!@#$");
		
		System.out.println(prop);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		// 파일 추출하기
		
		try {
//			prop.store(new FileWriter("login.properties"), "naver login information");
			// 사용자정의 태크
			prop.storeToXML(new FileOutputStream("login.xml"), "naver login information");
			System.out.println("파일 저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
