package kh.java.byte_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOStudy {

	public static void main(String[] args) {
		DataIOStudy study = new DataIOStudy();
//		study.test1();
		study.test2();

	}
	
	/**
	 *객체 선언하고 반납을 동시에 해주는 코드
	 * try (입출력 객체 선언문1; 입출력 객체 선언문1;){
	 * 
	 * } catch() {
	 * 
	 * }
	 * 
	 *
	 */
	public void tryWithResource() {
		try(
			DataInputStream dis = new DataInputStream(new FileInputStream("sample.dat")); //자동반납
		){
			
			// 입출력
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void test2() {
		
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("sample.dat"));
			
			// 작성된 타입 순서대로 읽어와야 한다.
			System.out.println(dis.readBoolean());
			
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());

			System.out.println(dis.readDouble());
			System.out.println(dis.readDouble());
		
			System.out.println(dis.readChar());
			System.out.println(dis.readChar());
			System.out.println(dis.readChar());

			System.out.println(dis.readUTF());			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 자료형별로 입출력
	 * DataInputStream
	 * DataOutputStream
	 * 
	 * 입출력을 따로 할것
	 */
	private void test1() {
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("sample.dat"));
			
			dos.writeBoolean(true);
			dos.writeInt(100);
			dos.writeInt(200);
			dos.writeInt(300);
			dos.writeDouble(1.2);
			dos.writeDouble(3.45678);
			dos.writeChar('a');
			dos.writeChar('b');
			dos.writeChar('c');
			dos.writeUTF("안녕하세요~ 반갑습니다.");
			
			System.out.println("쓰기 작업 완료!");
			
		} catch (IOException e) {
	
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
