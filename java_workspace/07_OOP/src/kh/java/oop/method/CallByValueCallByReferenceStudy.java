package kh.java.oop.method;

import java.util.Arrays;

public class CallByValueCallByReferenceStudy {

	/**
	 * CallByValue : 매개인자로 기본형을 전달할때 값복사
	 * CallByReference : 매개인자로 참조형을 전달할때 주소값복사가 일어나므로, heap의 객체를 공유한다.
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 100;
		int[] arr = {1, 2, 3};
		String s = "안녕";
		
		CallByValueCallByReferenceStudy study = new CallByValueCallByReferenceStudy();
//		study.callByValue(a);
//		System.out.println(a);
		
//		study.callByReference(arr);
//		System.out.println(Arrays.toString(arr));
		
		//String은 heap영역의 literal pool에 의해 공유
		//String은 immutable이므로 해당 문자열 객체를 직접 수정할 수 없다.
		//변경되지 않고, 새로 생성된다.
		study.callByString(s);
		System.out.println(s);
	}
	
	public void callByString(String str) {	
		str += "잘가";
	}
	
	public void callByReference(int[] brr) { //참초형
		brr[1] *= 100;
	}
	 
	public void callByValue(int n) { //기본형
		n *= 100;
	}

}
