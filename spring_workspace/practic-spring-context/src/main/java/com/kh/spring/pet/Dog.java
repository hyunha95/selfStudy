package com.kh.spring.pet;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {

	@Override
	public void helloPerson() {
		System.out.println("멍멍");

	}

}
