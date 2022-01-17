package ncs.test4;

import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		
		TestSort testsort = new TestSort();
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 50) + 51;
		}
		System.out.println("before : " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					testsort.swap(arr, i, j);
				}
			}
		}
		System.out.println("after : " + Arrays.toString(arr));
		
		
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
