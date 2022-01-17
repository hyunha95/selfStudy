package account;

public class AccountTest2 {

	public static void main(String[] args) {
		// 5개의 Account형 객체 배열 선언
		Account[] acc = new Account[5];
		// for문을 이용하여 Account 객체를 배열에 생성
		for(int i = 0; i < acc.length; i++) {
			String accountNum = "221-0101-211";
//			String result1 = accountNum + String.valueOf(i + 1);
			String result2 = accountNum.concat(String.valueOf(i + 1));
			acc[i] = new Account(result2, 100000, 0.045);
			System.out.println(result2);
		}
		// for문을 이용하여 Account 정보 출력
		for(Account account : acc) {
			account.AccountInfo();
			System.out.println();
		}
		System.out.println();
		// for문을 이용하여 이자율을 변경하고 이자를 화면에 출력
		for(int i = 0; i < acc.length; i++) {
			acc[i].setInterestRate(0.037);
			acc[i].AccountInfo();
			System.out.printf(" 이자 : %.0f%n", acc[i].calculateInterest());
		}
	}

}
