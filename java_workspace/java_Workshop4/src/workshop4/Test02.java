package workshop4;

public class Test02 {
	public static void main(String[] args) {
//		new Test2().study1();
		new Test02().study2();

	}
	
	// 중복불가
	private void study2() {
		int[] arr3 = new int[5];
		abc:
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] = (int)(Math.random() * 10) + 1;
			for(int j = 0; j < i; j++) {
				if(arr3[i] == arr3[j]) {
					i--;
					continue abc;
				}
			}
			System.out.print(arr3[i] + " ");
		}
	}

	// 중복허용
	public void study1() {
				int sum = 0;
				double avg = 0;
				int[] arr3 = new int[5];
				for(int i = 0; i < arr3.length; i++) {
					arr3[i] = (int)(Math.random() * 10) + 1;
					System.out.print(arr3[i] + " ");
					sum += arr3[i];
				}
				avg = sum / arr3.length;
				System.out.printf("%nsum=%d%n",sum);
				System.out.printf("avg=%.0f",avg);
	}
	

}
