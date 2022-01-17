package kh.java.thread.basic;

public class ThreadStudy {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작!");
		ThreadStudy study = new ThreadStudy();
//		study.test1();
		study.test2();
//		study.test3();
		System.out.println(Thread.currentThread().getName() + "끝!");
	}

	
	/**
	 * 멀티쓰레드2
	 * - Runnable인터페이스를 구현, run메소드를 오버라이드
	 */
	private void test3() {
		Runnable run1 = new Bar('+');
		Runnable run2 = new Bar('_');
		Thread th1 = new Thread(run1);
		Thread th2 = new Thread(run2);
		
		th1.start();
		th2.start();
	}
	
	static class Bar implements Runnable{
		private char ch;
		
		public Bar(char ch) {
			this.ch = ch;
		}
		/**
		 * 쓰레드 작업내용
		 */
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "시작!");
			for(int i = 0; i < 100; i++) {
				System.out.print(ch);
			}
			System.out.println(Thread.currentThread().getName() + "끝!");
		}
	}

	/**
	 * 멀티쓰레드1
	 * - Thread클래스를 상속, run메소드를 오버라이드
	 */
	private void test2() {
		Thread th1 = new Foo('=');
		Thread th2 = new Foo('|');
		
		// 우선순위 지정 1(낮음) ~ 10(높음)
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		
		// 쓰레드 시작
		th1.start(); // A작업
		th2.start(); // B작업
		
	}
	
	static class Foo extends Thread {
		private char ch;
		public Foo(char ch) {
			this.ch = ch;
		}
		/**
		 * 쓰레드 작업내용
		 */
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "시작!");
			for(int i = 0; i < 100; i++) {
				System.out.print(ch);
			}
			System.out.println(Thread.currentThread().getName() + "끝!");
		}
	}

	/**
	 * 싱글쓰레드 처리
	 * - A작업
	 * - B작업
	 */
	private void test1() {
		task('='); // A작업 
		task('|'); // B작업
		
	}
	
	public void task(char ch) {
		for(int i = 0; i < 100; i++) {
			System.out.print(ch);
		}
	}
}