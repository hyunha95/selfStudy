package com.kh.wrapper;

public class AnimalWrapper implements Animal {

	private Animal animal;
	
	public AnimalWrapper(Animal animal) {
		this.animal = animal;
	}
	
	@Override
	public String say() {
		String say = animal.say();
		String result = "";
		for(int i = 0; i < 5; i++)
			result += say;
		
		return result;
	}

	
}
