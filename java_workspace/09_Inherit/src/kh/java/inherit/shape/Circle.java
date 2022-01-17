package kh.java.inherit.shape;

/**
 * 
 * Circle은 하나의 Shape이다.		   - is a 상속관계 (일반화관계)
 * Circle은 중심점 Point를 가지고 있다. - has a 포함관계
 *
 *
 */
public class Circle extends Shape{
	
	private Point center;	// 중심점
	private int r;			// 반지름
	
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(Point center, int r) {
		super();
		this.center = center;
		this.r = r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	@Override
	public void draw() {
//		System.out.println("중심점이 ("+ center.getX() + ", " + center.getY() + ")이고, 반지름이 " + r + "인 원을 그린다.");
		System.out.println("중심점이 "+ center + "이고, 반지름이 " + r + "인 원을 그린다.");
		// center만 썼지만 자동으로 .toString이 호출된다. 객체를 문자열 정보로 출력되어야 할 때 자동으로 호출된다.
		
	}
	
	
}
