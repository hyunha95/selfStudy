package com.oop.person.controller;

import java.util.Scanner;

import com.oop.person.model.Person;

public class PersonController {

	public static final int MAX_PERSON = 5;
	private Person[] p = new Person[MAX_PERSON];
	Scanner sc = new Scanner(System.in);
	int ageSum = 0;
	double heightSum = 0;
	double weightSum = 0;
	int assetSum = 0;
	
	public void inputPerson() {
		for(int i = 0; i < p.length; i++) {
			Person person = new Person();
			System.out.print("이름 : ");
			person.setName(sc.next());
			System.out.print("나이 : ");
			person.setAge(sc.nextInt());
			System.out.print("키 : ");
			person.setHeight(sc.nextDouble());
			System.out.print("몸무게 : ");
			person.setWeight(sc.nextDouble());
			System.out.print("재산 : ");
			person.setAsset(sc.nextInt());
			
			ageSum += person.getAge();
			heightSum += person.getHeight();
			weightSum += person.getWeight();
			assetSum += person.getAsset();
			p[i] = person;
//			person.information();
		}
	}
	
	public void printPerson() {
		
		for(int i = 0; i < p.length; i++) {
			p[i].information();
		}
		
	}
	
	public void printAvg() {
		double avgAge = (double)ageSum / p.length;
		double avgHeight = heightSum / p.length;
		double avgWeight = weightSum / p.length;
		double avgAsset = (double)assetSum / p.length;
		
		System.out.println("평균 나이 : " + avgAge);
		System.out.println("평균 키 : " + avgHeight);
		System.out.println("평균 몸무게 : " + avgWeight);
		System.out.println("평균 재산 : " + avgAsset);
		
	}
}
