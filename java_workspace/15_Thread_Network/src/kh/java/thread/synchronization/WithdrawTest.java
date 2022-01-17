package kh.java.thread.synchronization;

/**
 * 
 * 임계영역 Critical section
 * - 멀티쓰레드환경에서 한번에 하나의 쓰레드만 사용할 수 있는 코드영역
 * - lock을 획득한 쓰레드만 임계영역에 접근 작업할 수 있다. lock을 반납해야 다른 쓰레드가 접근 가능
 *
 * 1. synchronized method : 한번에 하나의 쓰레드만 접근 가능. 해당객체가 임계영역으로 지정
 * 2. synchronized block : 블럭에 지정된 객체를 임계영역으로 지정. 동기화 method보다 더 세밀하게 임계영역을 지정할 수 있다.
 */
public class WithdrawTest {

	public static void main(String[] args) {
		Account acc = new Account();
		Thread atm1 = new Thread(new Atm(acc));
		Thread atm2 = new Thread(new Atm(acc));

		atm1.start();
		atm2.start();
	}
}
