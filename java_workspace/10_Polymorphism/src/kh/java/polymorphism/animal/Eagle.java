package kh.java.polymorphism.animal;

public class Eagle extends Animal implements Flyable{

	@Override
	public void say() {
		System.out.println("안녕하세요, 이글이글입니다.");
	}
	
	@Override
	public void attack() {
		peck();
	}
	
	public void peck() {
		System.out.println("독수리가 쪼았습니다.");
	}
	
	@Override
	public void fly() {
		System.out.println("독수리가 "+ Flyable.LEN_OF_WINGS +"날개로  시속"+ Flyable.SPEED +"km로 납니다.");
	}
}
