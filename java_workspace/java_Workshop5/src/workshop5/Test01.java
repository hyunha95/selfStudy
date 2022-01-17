package workshop5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		char[] chArr = args[0].toCharArray();
		for(int i = chArr.length - 1; i >=0; i--) {
			System.out.print(chArr[i]);
		}
		
		System.out.println();
		
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < chArr.length; i++) {
			list.add(chArr[i]);
		}
		list.sort(Collections.reverseOrder());
		System.out.println(list);
	}

}
