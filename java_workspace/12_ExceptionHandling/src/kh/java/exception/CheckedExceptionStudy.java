package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionStudy {

	public static void main(String[] args) {
		CheckedExceptionStudy study = new CheckedExceptionStudy();
		study.start();
		System.out.println("------ 프로그램 정상종료 -------");

	}

	private void start() {
		try {
		readFile();
		System.out.println("파일을 정상적으로 읽었습니다.");
		} catch (FileNotFoundException e){
			System.out.println("다른 파일 읽기 시도~");
		}

	}
		

	/**
	 * CheckedException : RuntimeException의 후손이 아닌 모든 예외클래스
	 * - 예외처리를 강제화
	 * - 예외가 발생했을 때 대안을 미리 작성해 둘것.
	 * 
	 * 1. 예외처리 try...catch
	 * 2. 예외회피 throws (메소드 호출부)
	 * 
	 * 예외처리룰 - 우선 예외를 처리하고, 흐름을 분기할 수 있는 곳으로 던져준다.
	 */
	private void readFile() throws FileNotFoundException{
		try {
		FileReader fr = new FileReader("user.txt");
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			throw e;
		}
	}
	
//	private void readFile() {
//		try {
//			FileReader fr = new FileReader("user.txt");	
//	
//		} catch(FileNotFoundException e) {
//			System.out.println("파일을 찾을 수 없습니다.");
//			e.printStackTrace();
//		}
//	}

}
