package kh.java.char_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWStudy {

	public static void main(String[] args) {
		FileRWStudy study = new FileRWStudy();
		study.test1();
	}

	/**
	 * 텍스트기반 파일을 문자단위로 처리
	 * - FileReader
	 * - FileWriter
	 */
	private void test1() {
//		FileReader fr = null;
//		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("note.txt"));
			bw = new BufferedWriter(new FileWriter("coooooooopy.txt"));
			
			//입출력
			String data = null;
			while((data = br.readLine()) != null) { //readLine은 개행문자까지 읽어와서 개행문자를 버린다.
				System.out.println(data);
				bw.write(data);
				bw.write("\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
