package test.controller;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test1();
	}
	
	public void test1() {
		int i = 1;
		double sum = 0.0;
		double avg = 0.0;
		while(i <= 100) {
			sum += (double)i;
			i++;
		}
		avg = sum / 100.0;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
}
