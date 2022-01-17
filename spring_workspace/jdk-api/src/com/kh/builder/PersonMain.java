package com.kh.builder;

import java.util.Date;

public class PersonMain {

	public static void main(String[] args) {
		Person person = 
				Person.builder() // Person.Builder객체
					.id("honggd") // Person.Builder.id
					.name("홍길동") // Person.Builder.name
					.build();
		System.out.println(person);

	}

}
