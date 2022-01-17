package ncs.test5;

import java.util.Scanner;

public class TestScore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] arr = new double[3][5];
		double[] total = new double[3];
		double[] avg = new double[3];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length - 2; j++) {
				System.out.print("(" + i + ", " + j+ ")" + "점수를 입력하세요 : ");
				arr[i][j] = sc.nextDouble(); 
				total[i] += arr[i][j];
			}
			avg[i] = total[i] / 3;
		}

		
		System.out.println("index  과목1  과목2  과목3  총점  평균");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "    ");
			for(int j = 0; j < arr[i].length; j++) {
				if(j == 3) {
					arr[i][j] = total[i];
				}
				if(j == 4) {
					arr[i][j] = avg[i];
				}
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}

		
		
		
	}
}
