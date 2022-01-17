package workshop4;

public class Test01 {
	
	public static void main(String[] args) {
		int total = 0;
		double average = 0;
		int cnt = 0;
		int[][] arr2 = {
				{ 5, 5},
				{10,10,10,10,10},
				{20,20,20},
				{30,30,30,30}
				};
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				total += arr2[i][j];
				cnt++;
			}
		}
		average = total /cnt;
		System.out.printf("total = %d%n", total);
		System.out.printf("average = %.1f", average);
	}
}
