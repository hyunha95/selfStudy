package account;

public class AccountTest {

	public static void main(String[] args) {
		//객체 생성
		Account acc = new Account("441-0290-1203", 500000, 0.073);
		// 기본 정보 출력
		System.out.println(acc);
		// 20000원 입금
		acc.deposit(20000);
		// 변경 정보 출력
		System.out.println(acc);
		// 이자 출력
		System.out.printf("이자 : %.1f", acc.calculateInterest());
	}

}
