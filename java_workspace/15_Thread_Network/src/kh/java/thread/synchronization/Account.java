package kh.java.thread.synchronization;

public class Account {
	
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	//1. 동기화 메소드
//	public synchronized void withdraw(int money) {
	public void withdraw(int money) {
		
		//2. 동기화 블럭 : this 현재객체, 멤버변수 또한 가능
		synchronized(this) {
			String name = Thread.currentThread().getName();
			System.out.printf("[%s] 잔액 : %d%n", name, balance);
			if(money <= balance) {
				balance -= money;
				System.out.printf("[%s] 출금 : %d, 잔액 : %d%n", name, money, balance);
				
			}
			else {
				System.out.printf("[%s] [잔액이 부족합니다.] 출금 : %d, 잔액 : %d%n", name, money, balance);
			}			
		}
	}
}
