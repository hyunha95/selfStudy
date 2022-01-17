package kh.java.inherit.basic;

public class Run {

	public static void main(String[] args) {
//		Parent p = new Parent();
//		p.name = "홍길동";
//		p.age = 30;
//		p.say();
//		System.out.println(p.info());
		
		Child c = new Child();
		c.name = "홍길순";
		c.age = 5;
		c.say();
		System.out.println(c.info());
		c.doGame();
		
		GrandChild gc = new GrandChild();
		gc.name = "홍길현";
		gc.age = 3;
		gc.say();
		System.out.println(gc.info());
		gc.doGame();
		
		System.out.println("-----------------------");
		
		OtherChild oc = new OtherChild();
		oc.name = "홍길동";
		oc.age = 20;
		oc.say();
		System.out.println(oc.info());
		
		// hashCode, toString... 은 Object로부터 상속받아서 사용가능
		// 상속모델의 최상위클래스는 Object이다. 
		System.out.println(gc.hashCode());
	}

}
