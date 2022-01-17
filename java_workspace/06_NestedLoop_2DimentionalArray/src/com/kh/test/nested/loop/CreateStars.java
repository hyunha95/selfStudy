package com.kh.test.nested.loop;

public class CreateStars {

	public static void main(String[] args) {
		CreateStars stars = new CreateStars();
//		stars.test1();
//		stars.test2();
//		stars.test3();
//		stars.test4();
//		stars.test5();
//		stars.test6();
//		stars.test7();
		stars.test8();
	}
	
	/**
	 * 바깥쪽 반복문은 5번 돌면서 1씩 감소한다.
	 * 5, 4, 3, 2, 1
	 * j는 i보다 작을때 까지만 반복한다.
	 */
	public void test1() {
		for(int i = 5; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print('*');
				}
			System.out.println();
		}
	}

	public void test2() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	/**
	 * 바깥쪽 반복문은 5번을 돌아야한다.
	 * 바깥쪽 반복문의 i를 1씩 감소시키면서
	 * j < i 가 만족 될때까지 공백을 찍고
	 * 조건이 만족되지 않으면 else를 출력한다.
	 * else도 반복해서 출력되어야 하기 때문에
	 * 안쪽 반복문 조건식에 i를 대입하면 안된다.
	 */
	public void test3() {
		for(int i = 5; i > 0; i--) {
			for(int j = 1; j <= 5; j++) {
				if(j < i) {
					System.out.print(' ');
				}
				else{
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}

	public void test4() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4-i; j++) {
				System.out.print(' ');				
			}
			for(int j = 0; j < (2 * i) + 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	public void test5() {
		for(int i = 0; i < 6; i+= 2) {
			
			for(int j = 0; j < 5; j++) {
				if(i > j) {
					System.out.print(' ');
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	/**

 @실습문제6
    *
  ***
*****
  ***		 
    *
  
	 */
	public void test6() {
		int total = 5; // 5행, 5*
		int space = 4; // 공백
		int mid = total/2; //가운데 기준으로 i와 mid의 값을 비교해 space값을 변경한다.
		
		// i : 0 1 2 3 4 
		for(int i = 0; i<total; i++) {
			// j = 0 1 2 3 4 
			for(int j = 0; j< total;j++) {
				System.out.print(j<space ? " " : "*");
			}
			
			//space : 4 - 2 - 0 - 2 - 4
			if(i < mid) {
				space -= 2;
			}
			else {
				space += 2;
			}
			
			System.out.println();
		}
	}
	
	/*
 @실습문제7 : 다이아몬드
  *  
 *** 
*****
 *** 
  * 
	 */
	public void test7() {
		int total = 5;
		int space = 2; // 행별 공백수
		int star = 1; // 행별 찍어야 할 별의 수
		int mid = total/2; //행의 가운데: i와 mid를 비교해서 space, star값을 변경한다.
		
		for(int i = 0; i < total; i++) {
			for(int j = 0; j < space+star;j++) {
				System.out.print(j < space ? " " : "*");
			}
			if(i<mid) {
				space--;
				star += 2;
			}
			else {
				space++;
				star -= 2;
			}
			System.out.println();
		}
	}
	
	/*
@실습문제8
*****
  ***		 
    *
  ***
*****
	 */
	public void test8() {

	}
}
	

	

/*
 * #@실습문제 - 별찍기
@실습문제1
*****
****
***
**
*
@실습문제2
*
**
***
****
*****
@실습문제3
    *
   **
  ***
 **** 
*****
@실습문제4
    *     
   ***    
  *****   
 *******  
********* 
@실습문제5
*****
  ***
    *
	
 */
