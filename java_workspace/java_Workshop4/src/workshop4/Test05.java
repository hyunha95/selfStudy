package workshop4;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~5까지의 정수 하나 입력");
		int n = sc.nextInt();
		int sum = 0;
		abc:
		for(int i = n; i < 10; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				continue abc;
			}
			System.out.print(i < 8 ? i + " + " : i);
			sum += i;
		}
		System.out.printf("%n결과 : %d", sum);
	}

}
