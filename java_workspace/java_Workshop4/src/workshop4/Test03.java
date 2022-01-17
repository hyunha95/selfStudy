package workshop4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test03 {

	int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

	public static void main(String[] args) {
		Test03 t = new Test03();
		t.list();
		System.out.println();
		t.sort();
	}
	
	public void list() {
		int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			list.add(arr[i]);			
		}
		list.sort(Collections.reverseOrder());
		for(int a : list) {
			System.out.print(a + " ");
		}
	}
	
	public void sort() {
		
		for(int i = 0; i < arr.length -1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private void swap(int[] arr2, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
