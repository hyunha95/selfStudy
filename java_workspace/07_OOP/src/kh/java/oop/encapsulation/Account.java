package kh.java.oop.encapsulation;

/**
 * 이름
 * 잔고
 * 
 * 주민번호
 * 계좌번호
 * 은행
 * 서명/직인
 * 만든지점
 * 만든날짜
 * 비밀번호
 * 입출금내역
 * 
 * 캡슐화란?
 * - 필드와 메소드를 묶어 클래스로 작성하는 것.
 * - 필드에 직접접근을 제한하고, 메소드를 통해서 우회적으로 필드를 사용하도록 하는 것.
 *
 */
public class Account {
	
	/**
	 * private 접근제한자 : 클래스 외부에서 직접접근을 방지
	 * public 접근제한자 : 어디에서든지 접근 가능
	 */
	private String name;
	private long balance;
	
	/**
	 * setter : 필드값 설정용 메소드
	 * 
	 * - 리턴타입 void
	 * - 메소드명은 set으로 시작하고, 대문자로 시작하는 필드명을 연결
	 * - 매개변수 타입은 필드의 타입과 동일
	 * - 전달받은 매개인자를 필드에 set해야함.
	 * 
	 * 블럭안의 parameter name
	 * 블럭안의 field name
	 * 이름이 똑같을 때는 가까이 있는게 우선됨
	 * 
	 * this란? 현재객체에 대한 메소드안에 숨겨진 참조변수
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	/**
	 * getter : 필드값 전달용 메소드
	 * 
	 * - 리턴타입은 전달할 필드의 타입
	 * - 메소드명은 get을 시작하고, 대문자로 시작하는 필드명을 작성
	 * - 매개변수는 선언하지 않는다.
	 * - 해당필드를 리턴
	 */
	public String getName() {
		return name;
	}
	public long getBalance() {
		return balance;
	}
	
	/**
	 * 입금메소드
	 */
	public void deposit(long money) {
		if(money > 0) {
			balance += money;
			System.out.printf("[%s]님 계좌에 %d원이 입금되었습니다.%n", name, money);
		}
		else {
			System.out.println("금액이 유효하지 않습니다.");
		}
	}
	
	/**
	 * 출금 메소드
	 */
	public void withdraw(long money) {
		if(balance >= money) {
			balance -= money;
			System.out.printf("[%s]님 계좌에 %d원이 출금되었습니다.%n", name, money);
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	/**
	 * java doc
	 * 계좌정보 출력메소드
	 */
	public void printAccount() {
		System.out.println("-------------------------");
		System.out.println("계좌주 : " + name);
		System.out.println("현재 잔액 : " + balance + "원");
		System.out.println("-------------------------");
	}
}
