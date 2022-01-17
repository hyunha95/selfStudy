package workshop4;

public class Test06 {

	public static void main(String[] args) {
		try {
			if(args.length == 1 || args.length < 2) {
				throw new ArrayIndexOutOfBoundsException();
			}
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int[][] arr = new int[a][b];
			for(int i = 0 ; i < arr.length; i++) {
				if(a < 1 || a > 5) {
					System.out.println("숫자를 확인 하세요");
				}
				else if(b < 1 ||b > 5) {
					System.out.println("숫자를 확인하세요");
				}
			}
			double sum = 0;
			double avg = 0;
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = (int)(Math.random() * 5) + 1;
					sum += arr[i][j];
					cnt++;
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.printf("%nsum = %.1f%n", sum);
			System.out.printf("avg = %.1f", sum / cnt);
			
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("다시 입력하세요");
		} 
	}
}
