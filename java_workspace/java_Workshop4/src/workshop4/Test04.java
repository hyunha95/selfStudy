package workshop4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Calc calc = new Calc();

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("5~10까지의 정수 중 하나를 입력하세요");
			int n = calc.calculate(sc.nextInt());
			System.out.print("짝수 : ");
			for(int i = 1; i < n; i++) {
				if(i % 2 == 0) {
					System.out.print(i + " ");
				}
			}
			System.out.printf("%n결과 : %d", n);
				
		} catch(InputMismatchException e) {
			System.out.println("정수만 입력하세요");
		}
		
		

	}

}
