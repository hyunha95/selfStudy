package kh.java.byte_object;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOStudy {

	public static void main(String[] args) {
		ObjectIOStudy study = new ObjectIOStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();

	}
	
	/**
	 * User[]
	 */
	public void test4() {
		File src = new File("users_arr.dat");
		try(
			ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
		){
//			Object obj = ois.readObject();
//			User[] userArr = (User[]) obj;
			User[] userArr = (User[]) ois.readObject();
			
			for(int i = 0; i < userArr.length; i++) {
				System.out.println(userArr[i]);
			}
			
		} catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		} 
	}
	
	/**
	 * User[]객체를 쓰고 읽기
	 */
	private void test3() {
		User[] arr = new User[3];
		arr[0] = new User("honggd", "1234", "01012341234");
		arr[1] = new User("sinsa", "1234", "01033334444");
		arr[2] = new User("toitoi", "1234", "01099998888");
			
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users_arr.dat"));	
		){
			oos.writeObject(arr);
			System.out.println("파일 쓰기 완료!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 입력 : users.dat의 내용을 읽어서 User객체로 메모리에 생성하기
	 */
	public void test2() {
		File src = new File("users.dat");
		try(
			ObjectInputStream ois = 
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
		){
			for(int i = 0; ; i++) {
				// 파일을 모두 읽어 끝에 다다랐을 때 readObject를 호출하면, EOFException이 발생!
				// End Of File Exception
				User user = (User) ois.readObject();
				System.out.println(user);
			}
			
		} catch(EOFException e) {	
			System.out.println("파일 읽어오기 완료!!!");
			
			
		} catch(IOException | ClassNotFoundException e){
			// multi-catch절 : 두개이상의 타입을 catch절에 지정할 수 있다.
			// 부모자식 타입은 함께 쓸 수 없다.
			e.printStackTrace();
		} 
	}

	/**
	 * 객체단위로 입출력을 지원하는 스트림 클래스
	 * 
	 * - ObjectInputStream
	 * - ObjectOutputStream
	 * 
	 * 입출력할 객체가 반드시 Serializable 인터페이스를 구현해야 한다.
	 * - 객체의 내용을 직렬화 형태로 만들어서 입출력 가능하게 한다.
	 * 
	 */
	private void test1() {
		User[] arr = new User[3];
		arr[0] = new User("honggd", "1234", "01012341234");
		arr[1] = new User("sinsa", "1234", "01033334444");
		arr[2] = new User("toitoi", "1234", "01099998888");
		
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"));	
		){
			for(User u : arr) {
				oos.writeObject(u);
			}
			System.out.println("파일 쓰기 완료!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
