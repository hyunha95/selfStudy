package account;

public class Account {

	private String account;
	private int balance = 500000;
	private double interestRate;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public int getBalance() {
		return balance;
	}
	
	public double calculateInterest() {
		return (double)balance * interestRate;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) {
		if(balance < money) {
			System.out.println("잔고가 부족합니다.");
		}
		balance -= money;
		
	}
	@Override
	public String toString() {
		return "계좌정보 : " + account + " 현재잔액 : " + balance;
	}

	public void AccountInfo() {
		System.out.print("계좌정보 : " + account + " 현재잔액 : " + balance 
				+ " 이자율 : " + Math.floor(interestRate *1000) / 10  + "%");
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
