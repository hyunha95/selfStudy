package kh.java.oop.encapsulation;

public class AccountMain {

	public static void main(String[] args) {
		//0. 객체생성 & 필드값대입
		Account acc = new Account();
//		acc.name = "홍길동";
//		acc.balance = 1_000_000;
		acc.setName("홍길동");
		acc.setBalance(1_000_000);
		acc.printAccount();
		
		String name = acc.getName();
		System.out.println("이름 : " + name);
		long balance = acc.getBalance();
		System.out.println(balance);
		
		//1. 입금 : +500_000
//		acc.balance += 500_000;
		acc.deposit(500_000);
		acc.deposit(-500_000);
		acc.printAccount();
		
		//2. 출금 : -800_000
//		acc.balance -= 800_000;
		acc.withdraw(800_000);
		acc.withdraw(8_000_000);
		acc.printAccount();

	}

}
