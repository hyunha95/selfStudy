package kh.java.basic;

public class VariableArgsStudy {

	/**
	 * 가변인자 : 타입이 동일한 여러개(개수가 정해지지 않음)의 매개인자를 처리할 수 있다.
	 * 
	 * 메소드 선언부에서 마지막 변수로만 선언할 것
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VariableArgsStudy study = new VariableArgsStudy();
		study.test("홍길동", 1);
		study.test("홍길동", 1, 2);
		study.test("홍길동", 1, 2, 3);
		study.test("홍길동", 1, 2, 3, 4);
		study.test("홍길동", 1, 2, 3, 4, 5);
		
		int[] arr = {1, 2, 3, 4, 5};
		study.test("홍길동", arr);
	}
	
	public void test(String name, int... arr) {
		System.out.println(name);
		// int[]
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println("\n");
	}
}
