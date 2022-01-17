package com.exception.rnd;
/**
 * <문제 3>
* 메소드 작성/사용 연습
클래스명 : com.exception.rnd.NumberOk.java
임의의 난수(1~100사이의 정수)를 발생시켜 키보드로 입력된 값과 비교하여, 임의의 정수를 알아 맞히는 프로그램

main 메서드 : 
	- 메서드 호출은 객체레퍼런스를 통해 게임시작메소드 호출.
키보드 입력용 메서드 : +getNumber() : int 
	- 사용자의 입력예외에 대해 예외처리 할 것
메서드명 : +checkNumber(int) : int
	- 이 메서드에 키보드로 입력받은 정수를 넘겨 
          임의로 발생된 정수와 비교하여, 같으면 0
				  난수보다 적으면 -1,
				  난수보다 크면 1을 리턴함
메인에서 반환값에 따라 정수를 맞힐 때 까지 checkNumber 반복 실행
값을 맞히면 "맞았습니다." 출력하고, 몇번째에 맞혔는지도 출력
계속 할 것인지 물어서, y 이면 계속, n 이면 종료시킴

예)
임의의 정수 발생(화면에 안보이게 함) : 예를 들면 55
정수 입력 : 50
입력한 숫자보다 작습니다.
정수 입력 : 60
입력한 숫자보다 큽니다.
정수 입력 : 55
맞았습니다.(3번$$

계속 하시겠습니까?(y/n) : n
프로그램을 종료합니다.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOk {
	
	int rndNumber = (int)(Math.random() * 100) + 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NumberOk num = new NumberOk();
		char ch ='y';
		int count = 0;
		
		while(ch == 'y') {
			int inputNum = num.getNumber();
			// getNumber에서 예외처리된 정수를 checkNumber에 대입
			// checkNumber가 0이 아니면 계속 반복문 실행
			if(num.checkNumber(inputNum) == 0) {
				System.out.println("맞았습니다. 반복횟수 : " + count);
				System.out.println("계속하시겠습니까? (y/n)");
				ch = sc.next().charAt(0);
				// 게임을 다시 시작할때 반복횟수 초기화
				count = 0;
				// 게임을 다시 시작할때 새로운 난수
				num.rndNumber = (int)(Math.random() * 100) + 1;
			}
			count++;
		}
		System.out.println("프로그램 종료");
	}

	public int getNumber() {
		Scanner sc = new Scanner(System.in);
		int inputNum= 0;
		while(true) {
			try {
				System.out.print("1~100사이의 정수입력 : ");
				inputNum = sc.nextInt();	
				if(inputNum < 1 || inputNum > 100) {
					new InputMismatchException();
				} 
			} catch(InputMismatchException e) {			
				sc.nextLine();
				System.err.println("1~100사이의 정수를 입력하세요.\n");
				continue;
			}
			break;
		}
		return inputNum;
	}
	
	public int checkNumber(int n) {
		int flagNumber = 0; // 같다고 가정
		
		if(rndNumber == n){
			return 0;
		} else if(rndNumber < n){
			System.out.println("입력한 숫자보다 작습니다.");
			flagNumber = -1;
		} else {
			System.out.println("입력한 숫자보다 큽니다.");
			flagNumber = 1;
		} 
		return flagNumber;
	}
}
