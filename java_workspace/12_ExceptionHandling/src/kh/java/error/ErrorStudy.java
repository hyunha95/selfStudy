package kh.java.error;

public class ErrorStudy {

	public static void main(String[] args) {
		ErrorStudy study = new ErrorStudy();
		study.test1();
	}
	
	/**
	 * Error : 프로그램 수행시 치명적 상황이 발생한 것으로 소스코드(예외처리)로 해결이 불가한 경우
	 * 
	 * OutOfMemoryError
	 * StackOverflowError
	 * 
	 */
	public void test1() {
//		double[] arr = new double[Integer.MAX_VALUE];
		// java.lang.OutOfMemoryError: Requested array size exceeds VM limit
		
		System.out.println("test1");
		test1();
		// java.lang.StackOverflowError
		
		
	}

}
