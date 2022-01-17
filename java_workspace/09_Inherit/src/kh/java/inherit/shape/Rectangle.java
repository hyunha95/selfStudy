package kh.java.inherit.shape;
/**
 * @실습문제 : Shape클래스를 상속받은 Rectagle클래스를 작성하세요.
@kh.java.inherit.shape.Rectangle    
필드
* points: Point[4]  0번지-leftTop, 1번지-rightTop, 2번지-rightBottom, 3번지-leftBottom 
* width : int
* height : int
생성자
* 기본생성자
* 파라미터생성자 : Point[] points, int width, int height
다음 메소드를 오버라이딩할 것.
* draw()메소드: 
* getArea()메소드 
* toString 메소드
    실행클래스)
        Point[] points = {new Point(0,0), new Point(200,0), new Point(200,100), new Point(0,100)};
        Rectangle rect = new Rectangle(points, 200, 100);
        rect.draw();
        System.out.println("사각형의 너비는 "+rect.getArea()+"입니다.");
        System.out.println(rect);
    출력결과)
        네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.
        사각형의 너비는 20000.0입니다.
        points=[(0, 0), (200, 0), (0, 100), (200, 100)], width=200, height=100 
 * 
 *
 */

public class Rectangle extends Shape{

	private Point[] points;
	private int width;
	private int height;
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(Point[] points, int width, int height) {
		super();
		this.points = points;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.print("네 꼭지점이 ");
		for(int i = 0; i < points.length;i++) {
			System.out.print(points[i]);
			System.out.print(i < points.length - 1 ? ", " : "");
		}
		System.out.println("이고, 너비가 " + width + ", 높이가 " + height + "인 사각형을 그린다.");
	}
	@Override
	public double getArea() {
		return width * height;
	}
	@Override
	public String toString() {
		return "points=[" + points[0] + ", "  + points[1] + ", " + points[2] + ", " + points[3] + "], width=" +
				width + ", height=" + height;
	}
}
