package kh.java.inherit.shape;

public class Point {

	private int x;
	private int y;
	
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 객체를 문자열 정보로 변환하는 메소드
	 * 1. java.lang.Object.toString():String
	 * 2. 필드정보확인용 override
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
