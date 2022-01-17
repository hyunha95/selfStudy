package kh.java.oop.method;

public class SampleMain {

	public static void main(String[] args) {
		// test1 호출 non-static
		Sample s = new Sample();
		s.test1();
		
		//test2 호출 static
		Sample.test2();

	}

}
