package com.calc;

public class Calculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		c.test1(a, b);
	}
	
	public void test1(int a, int b) {
		System.out.printf("합 : %d%n", (a + b));
		System.out.printf("차 : %d%n", (a - b));
		System.out.printf("곱 : %d%n", (a * b));
		System.out.println(a == 0 || a < 0 ? "나누기 : 0" : "나누기 : " + (a/b));
	}
	
	
}
