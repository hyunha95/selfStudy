package kh.java.thread.basic;

import javax.swing.JOptionPane;

public class ThreadControlStudy {

	public static void main(String[] args) {
		ThreadControlStudy study = new ThreadControlStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
		System.out.println("-----" + Thread.currentThread().getName() + " 종료 ----");
		
	}
	
	/**
	 * interrupt
	 * - 지정한 쓰레드를 취소하는 용도.
	 * - 일시정지 상태의 쓰레드에 InterruptedException을 유발 -> catch절을 통한 다음 액션을 취하도록함.
	 */
	private void test4() {
		Thread th = new Thread(new CountDown());
		th.start();
		
		JOptionPane.showMessageDialog(null, "OK를 누르시면 폭탄이 즉시 터집니다.");
		th.interrupt(); // countdown thread에 InterruptedException을 유발
	}

	/**
	 * thread.join()
	 * 현재 쓰레드에서 
	 * 1. 지정한 쓰레드가 종료할때까지 기다림.
	 * 2. 특정시간만큼 기다림.
	 */
	public void test3() {
		Thread th = new Thread(new CountDown());
		th.start();
		
		try {
			th.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Daemon Thread
	 * - linux/unix운영체제에서 백그라운드 프로세스를 가리키는 말.
	 * - 일반쓰레드가 종료되면 자동으로 종료된다.
	 * - 사용자가 글쓰는 동안 임시저장쓰레드를 데몬으로 지정해두면 좋다.
	 */
	private void test2() {
		Thread th1 = new Thread(new CountDown());
		th1.setDaemon(true);
		th1.start();
		
		JOptionPane.showMessageDialog(null, "확인을 누루면 메인쓰레드는 종료합니다.");
	}
	
	/**
	 * 1초단위로 10부터 0까지 출력후 종료하는 쓰레드 클래스
	 *
	 */
	static class CountDown implements Runnable{
		@Override
		public void run() {
			for(int i = 10; i > 0; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("쾅!!!");
		}
		
	}

	/**
	 * sleep
	 * 지정한 쓰레드에 지정시간동안 일시정지(TIMED WAITING) 상태로 만든다.
	 */
	private void test1() {
		Thread th1 = new Thread(new koo('=', 100));
		Thread th2 = new Thread(new koo('|', 30));
		
		th1.start();
		th2.start();
	}
	
	static class koo implements Runnable{
		private char ch;
		private long millis; // sleep할 밀리초
		
		public koo(char ch, long millis) {
			this.ch = ch;
			this.millis = millis;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				System.out.print(ch);
				try {
					// 현재쓰레드에 millis초만큼 일시정지
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
