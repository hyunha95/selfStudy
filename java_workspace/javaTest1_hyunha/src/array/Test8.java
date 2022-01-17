package array;

public class Test8 {

	public static void main(String[] args) {
		Test8 t = new Test8();
		t.test();
	}
	
	public void test() {
		int [][] array = {{12, 41, 36, 56}, 
						  {82, 10, 12, 61}, 
						  {14, 16, 18, 78}, 
						  {45, 26, 72, 23}}; 
		double sum = 0.0;
		double avg = 0.0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sum += (double)array[i][j];
			}
		}
		avg = sum / (array.length * array[0].length);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
}
