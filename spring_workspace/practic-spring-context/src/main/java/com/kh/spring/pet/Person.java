package com.kh.spring.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private Pet pet;

	@Autowired
	public Person(Pet pet) {
		super();
		this.pet = pet;
	}
	
	public void helloPet() {
		pet.helloPerson();
	}
}
