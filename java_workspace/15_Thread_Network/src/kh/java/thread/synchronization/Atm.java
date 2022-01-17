package kh.java.thread.synchronization;

public class Atm implements Runnable{

	private Account acc;
	
	public Atm(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		
		while(acc.getBalance() > 0) {
			delay(2000);
			int money = (int)(Math.random() * 3 + 1) * 100; // 100 | 200 | 300
			acc.withdraw(money);
		}
		
		System.out.println(Thread.currentThread().getName() + " 종료!");
	}

	private void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
