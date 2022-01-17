package array;

import java.util.Arrays;

public class Test9 {

	public static void main(String[] args) {
		Test9 t = new Test9();
		t.test();
	}
	
	public void test() {
		int [][] array = {
				{12, 41, 36, 56}, 
				{82, 10, 12, 61}, 
				{14, 16, 18, 78}, 
				{45, 26, 72, 23}};
		
		// 초기값 지정
		int max = Integer.MIN_VALUE; //정수최소값으로 지정후, 이것보다 큰값을 기대
		int min = Integer.MAX_VALUE; // 정수최대값을 지정후, 이것보다 작은값을 기대
//		int max = array[0][0];
//		int min = array[0][0];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				
				// 현재수가 max보다 크다면, 현재수를 max로 지정
				if(max < array[i][j])
					max = array[i][j];
				// 현재수가 min보다 작다면, 현재수를 min로 지정
				if(min > array[i][j])
					min = array[i][j];
			}
		}
		System.out.println("가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
	}	
}

	





