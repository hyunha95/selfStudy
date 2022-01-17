package kh.java.array;

public class ArrayCopyStudy {

	public static void main(String[] args) {
		ArrayCopyStudy study = new ArrayCopyStudy();
//		study.shallowCopy();
//		study.deepCopy();
		study.deepCopy2();
	}
	
	public void deepCopy2() {
		// 1. System.arraycopy
		int[] arr = {12, 34, 56, 78, 90};
		int[] dest = new int[arr.length];
		
		//void java.lang.System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		// arr의 0번째 부터. dest의 0번째 부터. 복사할 값의 수 
		System.arraycopy(arr, 0, dest, 0, arr.length);
		
		printArr(arr);
		printArr(dest);
		
		// 2. clone
		int[] copy = arr.clone();
		printArr(copy);
		
		System.out.println(arr.hashCode());
		System.out.println(dest.hashCode());
		System.out.println(copy.hashCode());
	}
	
	/**
	 * 깊은 복사
	 * - heap 영역의 배열을 새로 생성해서 각 번지의 값을 동일하게 복사한다.
	 * 
	 * 1. 반복문을 통해 구현
	 * 2. System.arraycopy
	 * 3. array.clone();
	 */
	public void deepCopy() {
		int[] arr = {1, 2, 3, 4, 5};
		int[] copy = new int[arr.length];
		
		//각 번지수별로 값복사
		for(int i = 0; i < arr.length; i++) {
			// 좌항의 공간에 우항의 값을 대입!
			copy[i] = arr[i];
		}
		
		arr[2] = 100;
		
		printArr(arr);
		printArr(copy);
		
		System.out.println(arr.hashCode());
		System.out.println(copy.hashCode());
	}
	
	/**
	 * 얕은 복사
	 *  - 주소값만 복사.
	 *  - 같은 배열 객체를 가리키게 된다.
	 *  - 한쪽에서 수정하면, 다른 쪽에서도 수정내역을 확인할 수 있다.
	 */
	public void shallowCopy() {
		int[] arr = {1, 2, 3, 4, 5};
		int[] copy = arr; 
		
		printArr(arr);
		printArr(copy);
		
		System.out.println(arr.hashCode());
		System.out.println(copy.hashCode());
		
	}
	
	/**
	 * [1, 2, 3, 4, 5]
	 * @param arr
	 */
	public void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i == 0 ? "[" : "");
			System.out.print(arr[i]);
			System.out.print(i < arr.length - 1 ? ", " : "]\n");
		}
	}
}
