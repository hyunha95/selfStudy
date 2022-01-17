package workshop4;

public class Calc {

	public int calculate(int data) {
		int sum = 0;
		for(int i = 2; i < data; i += 2) {
			sum += i;
		}
		return sum;
	}
}
