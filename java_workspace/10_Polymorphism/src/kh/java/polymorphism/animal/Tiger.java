package kh.java.polymorphism.animal;

public class Tiger extends Animal implements Runnable{

	public void kick() {
		System.out.println("타이거 킥을 날립니다.");
	}
	
	@Override
	public void attack() {
		kick();
	}
	
	@Override
	public void say() {
		System.out.println("안녕, 난 타이거야~");
	}
	
	@Override
	public void run() {
		System.out.println("타이거가 " + Runnable.LEN_OF_LEGS+"다리로 달립니다.");
	}
}
