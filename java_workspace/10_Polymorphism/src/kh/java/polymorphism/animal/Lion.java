package kh.java.polymorphism.animal;

public class Lion extends Animal implements Runnable{

	public void punch() {
		System.out.println("라이언 펀치를 날립니다.");
	}
	
	@Override
	public void attack() {
		punch();
	}
	
	@Override
	public void say() {
		System.out.println("안녕, 나 라이언이야!");
	}
	
	@Override
	public void run() {
		System.out.println("라이언이 " + Runnable.LEN_OF_LEGS+"다리로 달립니다.");
	}
	
}