package kh.java.byte_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIOStudy {

	public static void main(String[] args) {
		SystemIOStudy study = new SystemIOStudy();
		study.test1();
//		study.test2();

	}
	
	public void test2Simple() {
		System.out.println("키보드 입력을 시작합니다...");
		System.out.println("입력한 정수의 합을 구해드립니다....");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		try {
			// 사용자가 exit 입력한 경우, 종료
			while(true) {
				String data = br.readLine();
				if("exit".equals(data))
					break;
				sum += Integer.valueOf(data);
				System.out.println(sum);
			}
			System.out.println("누적합은 " + sum + "입니다.");
			System.out.println("---- 입력 종료 ----");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * BufferedReader 보조스트림
	 * InputStreamReader 브릿지 보조스트림
	 * -------------------------------
	 * System.in  기본스트림
	 * 
	 * 기본스트림에는 하나이상의 보조스트림을 끼워쓸 수 있다.
	 * 최종 보조스트림으로 제어하게 된다.
	 * 
	 */
	private void test2() {
		System.out.println("키보드 입력을 시작합니다...");
		System.out.println("입력한 정수의 합을 구해드립니다....");
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data = null;
		int sum = 0;
		
		try {
			// 사용자가 exit 입력한 경우, 종료
			// readLine 한 줄씩 읽어온다, String을 리턴한다.
			while((data = br.readLine()) != null) {
				System.out.println(data);
				if("exit".equals(data))
					break;
//				sum += Integer.parseInt(data);
				sum += Integer.valueOf(data);
				System.out.println(sum);
			}
			System.out.println("누적합은 " + sum + "입니다.");
			System.out.println("---- 입력 종료 ----");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * System.in 표준입력(사용자키보드입력) byte 기반
	 * System.out 표준출력(콘솔출력) 
	 * 
	 * Scanner
	 * - 사용자입력값을 문자열로 읽어온다.
	 * - 지정한 타입으로 형변환
	 * - 예외처리
	 * 
	 * 이클립스 Ctrl + z : 종료 (read메소드에서 -1을 리턴)
	 * 맥(Ctrl + d)
	 * 윈도우CMD : Ctrl + c
	 */
	private void test1() {
		System.out.println("키보드 입력을 시작합니다....");
		
		int data = 0;
		
		try {
			// read : 사용자입력값 1byte읽어서 int 리턴
			// - 1은 값없음을 의미함
			while((data = System.in.read()) != - 1) {
				System.out.println((char)data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
