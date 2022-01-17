package exception;

public class Account {
	
	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {
		
	};
	public Account(String account, double balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return balance * 0.073;
	}
	
	public void deposit(double money) throws Exception {
		if(money < 0) {
			throw new Exception();
		}
		else {
			balance += money;			
		}
	}
	
	public void withdraw(double money) throws Exception{
		if(money < 0 || money > balance) {
			throw new Exception();
		}
		else {
			balance -= money;
		}
	}
	
	@Override
	public String toString() {
		return "계좌정보 : " + account + "  " + balance + "  " + (interestRate * 100);
	}
	
}
