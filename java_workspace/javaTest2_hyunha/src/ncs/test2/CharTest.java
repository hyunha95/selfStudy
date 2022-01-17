package ncs.test2;

import java.util.Arrays;

public class CharTest {

	public static void main(String[] args) {
		char[] chArr = new char[args[0].length()];
		for(int i = 0; i < args[0].length(); i++) {
			chArr[i] = args[0].toUpperCase().charAt(i);
		}
//		System.out.println(Arrays.toString(chArr));
//		System.out.println(chArr.length);
		for(int i = chArr.length - 1; i >= 0; i--) {
			System.out.print(chArr[i]);
		}
	}
}
