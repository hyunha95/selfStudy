package kh.java.oop.method;

/**
 * 재귀적 호출
 * - 메소드에서 메소드 스스로를 다시 호출하는 것
 * - 무한호출이 되면 StackOverflowError를 유발.
 * - 종료조건(Basecase) 명시
 */
public class RecursionStudy {

	public static void main(String[] args) {
		RecursionStudy study = new RecursionStudy();
		int result = study.test1(5);
		System.out.println("result = " + result);
		
		result = study.power(5, 3);
		System.out.println("result = " + result);
	}
	
	/**
	 * base의 n제곱을 재귀적으로 처리하기
	 * 
	 */
	public int power(int base, int n) {
		System.out.println("power(" + base + ", " + n + ")");
		if(n == 0) {
			return 1;
		}
		return base * power(base, n - 1);
	}
	
	/**
	 * factorial
	 * 5! = 5 * 4 * 3 * 2 * 1
	 */
	public int test1(int n) {
		System.out.println("test1(" + n + ")");
		// 종료조건 basecase
		if(n == 1) 
			return 1;
		return n * test1(n - 1);
	}

}
