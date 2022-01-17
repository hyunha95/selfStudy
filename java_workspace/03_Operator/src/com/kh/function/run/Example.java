package com.kh.function.run;

import java.util.Scanner;

public class Example {

	public void onSample1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		
		int totalScore = korean + english + math;
		double avgScore = totalScore / 3;
		
		String pass = (korean >= 40) && (english >= 40) && (math >= 40) && (avgScore >= 60) ? "합격" : "불합격" ;
		System.out.println(pass);
	}
	
	public void onSample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생이름 : ");
		String name = sc.next();
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int class1 = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("성별(M/F) : ");
		
		// string.toUpperCase(), string.toLowerCase()
		
		char gender = sc.next().toUpperCase().charAt(0);
		String maleOrFemale = (gender == 'M') ? "남학생" : "여학생";
		
		System.out.print("성적 : ");
		double score = sc.nextDouble();
			
		System.out.printf("%d학년 %d반 %d번 %s %s은 성적이 %.2f이다", grade, class1, number, maleOrFemale, name, score);
	}
	
	public void onSample3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int variable = sc.nextInt();
		String result = variable > 0 ? "양수" : (variable == 0 ? "0" : "음수");
		System.out.println(result);
	}
	
	public void onSample4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		String result = num % 2 == 0 ? "짝수다" : "홀수다";
		System.out.println(result);
	}
}





