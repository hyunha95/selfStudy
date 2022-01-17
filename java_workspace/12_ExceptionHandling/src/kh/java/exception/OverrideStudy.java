package kh.java.exception;

import java.io.IOException;
import java.sql.SQLException;

public class OverrideStudy {

	public static void main(String[] args) {
		Child child = new Child();
		child.foo();

	}

}

class Parent {
	
	protected void foo() throws IOException, SQLException {
		
	}
} 

class Child extends Parent {
	
	/**
	 * 1. 접근제한자를 더 개방할 수 있다. protected -> public
	 * 2. 공변반환타입
	 * 3. 던지는 예외의 개수를 줄이거나, 자식타입으로 변환할 수 있다.
	 */
	@Override
//	public void foo() throws IOException, SQLException{
//	public void foo() throws IOException{
//	public void foo() throws FileNotFoundException{
	public void foo() {
		
	}
}





