package ncs.test6;

public class CalcTest {

	public static void main(String[] args) {
		Calculate calc = new Calculate();
		
		System.out.println("합 : " + calc.sum(2, 4));
		System.out.println("차 : " + calc.subtract(6, 4));
		System.out.println("곱 : " + calc.multiply(2, 4));
		System.out.println("나누기 : " + calc.divide(4, 2));

	}

}
