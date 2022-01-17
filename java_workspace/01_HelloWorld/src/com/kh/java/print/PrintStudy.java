package com.kh.java.print;

public class PrintStudy {

		public static void main(String[] args) {
			PrintStudy study = new PrintStudy();
			//study.test1();
			study.test2();
		}
		/**
		 * Escaping 처리
		 * \n : 개행
		 * \t : 탭
		 * \" : 문자 그대로 쌍따옴표
		 * \\ : 문자 그대로 역슬래시
		 * 
		 * 홍길동
		   		"신사임당"
					세종대왕\"\'\/
		 */
		public void test2() {
			System.out.print(1+ "\n");
			System.out.print("그는 말했다. \"안녕\"이라고~\n");
			System.out.println("C:\\dev");
			System.out.println("\t잘가");
			
			System.out.println("홍길동\n\t\"신사임당\"\n\t\t세종대왕\\\"\\'\\/");
		}
		
		public void test1() {
			System.out.println("안녕하세요."); // 괄호안의 내용을 출력한 우에 개행(줄바꿈)하라.
			System.out.print("파파고입니다."); // 괄호안의 내용을 출력하라.
			System.out.print(1);
			System.out.print(2);
			System.out.print(3);
		}
}
