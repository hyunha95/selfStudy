package com.kh.spring.pet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PetMain {

	public static void main(String[] args) {
		String configLocation = "/pet-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		System.out.println("=========== Spring Container 빈등록 완료 ==============");
		
		
		Person person = context.getBean(Person.class);
		person.helloPet();
		
	}

}
