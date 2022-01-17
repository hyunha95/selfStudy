package test.controller;

public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test1();
	}
	
	public void test1() {
		for(int i = 2; i <= 5; i++) {
			for(int j = 1; j <= 9; j++) {
				int result = i*j;
				if(result % 2 != 0) {
					System.out.printf("%d * %d = %d%n", i, j, i*j);					
				}
			}
		}
	}
}
