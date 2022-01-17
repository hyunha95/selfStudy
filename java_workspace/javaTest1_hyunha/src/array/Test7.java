package array;

public class Test7 {

	public static void main(String[] args) {
		Test7 t = new Test7();
		t.test();
	}
	
	public void test() {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		double sum = 0.0;
		
		for(int i =0; i < array.length; i++) {
			if(array[i] % 2 == 0) {
				continue;
			}
			System.out.println(array[i]);
			sum += (double)array[i];
		}
		System.out.println("합계 : " + sum);
	}
}
