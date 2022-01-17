package kh.java.byte_file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStudy {

	public static void main(String[] args) {
		FileIOStudy study = new FileIOStudy();
		study.test1();
//		study.test2();

	}
	
	/**
	 * File - FileInputStream
	 */
	public void test2() {
		// 존재/존재하지 않는 파일을 가리키는 자바객체. 파일생성/삭제/이동
		File src = new File("C:\\Workspaces\\damon-lam--1zDL1Ep-Wk-unsplash.jpg"); //경로중에 한글 있으면 안됨
		File dest = new File("copy.jpg"); //확장는 똑같이 만들어준다. 
		BufferedInputStream bis = null; // 성능향상을 위해서 보조스트림을 끼워쓴다
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			// 입출력
			int data = 0;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("파일 입출력 종료!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 보조스트림만 자원반납하면 내부에 있는 스트림까지 싹 자원 반납됨
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 대상이 File, byte기반 입출력스트림
	 * 
	 * - FileInputStream
	 * - FileOutputStream
	 * 
	 * 프로젝트 루트디렉토리의 note.txt파일 읽어오기
	 * 
	 * 표준입출력을 제외한 모든 스트림객체는 자원반납해야 한다.
	 */
	private void test1() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("note.txt"); // 없다면 FileNotFoundException
			fos = new FileOutputStream("noteCopy.txt"); // 없다면 creat, 존재한다면 덮어쓰기
			
			int data = 0;
			while((data = fis.read()) != -1) {
//				System.out.print(data + " ");
				//한글은 3byte로 이루어짐. 한글 못읽음
				System.out.print((char) data);
				fos.write(data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			//자원반납
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
