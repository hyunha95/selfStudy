package array;

import java.util.Arrays;

public class Test10 {

	public static void main(String[] args) {
		Test10 t = new Test10();
//		t.test();
		t.test1();
	}
	
	//선생님 풀이
	public void test1() {
		int [][] array = {
				{12, 41, 36, 56}, 
				{82, 10, 12, 61}, 
				{14, 16, 18, 78}, 
				{45, 26, 72, 23}
				}; 
		
		//3의 배수가 몇개인지 알 수 없으므로 최대크기의 배열을 우선 생성한다.
		int[] copyAr = new int[array.length * array[0].length];
		int copyIndex = 0;
		
		for(int i = 0; i < array.length; i++) {
			abc:
			for(int j = 0; j < array.length; j++) {
				int n = array[i][j];
				if(n % 3 == 0) {
					// 중복검사 : copyIndex에는 이제까지 추가된 요소의 개수가 담겨있다.
					for(int k = 0; k < copyIndex; k++) {
						// 중복된 수가 있다면 ...
						if(copyAr[k] == n) {
							continue abc;
						}
					}
					copyAr[copyIndex++] = n; // 추가할 요소의 인덱스 & 이제까지 추가된 요소의 개수
					System.out.println(Arrays.toString(copyAr));
					System.out.println();
				}
			}
		}
		System.out.println(Arrays.toString(copyAr));
	}
	
	/**
	 * 1. 1차원 배열에 임의의 개수의 3의배수를 저장하기
	 * 2. 중복을 제거
	 */
	public void test() {
		int [][] array = {
				{12, 41, 36, 56}, 
				{82, 10, 12, 61}, 
				{14, 16, 18, 78}, 
				{45, 26, 72, 23}
				}; 
		
		//3의 배수가 몇개인지 알 수 없으므로 최대크기의 배열을 우선 생성한다.
		int[] copyAr = new int[array.length * array[0].length];
		int k = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] % 3 == 0) {
					copyAr[k] = array[i][j];
					k++;
				}
			}
		}
		System.out.println("copyAr : " + Arrays.toString(copyAr));

	}
}
