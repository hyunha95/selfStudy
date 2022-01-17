package member.model.vo;


import member.model.vo.other.Member;

public class Silver extends Member{

	
	public Silver(){
		
	}
	public Silver(String name, String grade, int point) {
//		super(name, grade, point);
		
		//직접 접근
		this.name= name;
		this.grade = grade;
		this.point = point;
	}
	
	@Override
	public double getInterestPoint() {
		return  super.getPoint() * 0.02;
	}
	
	@Override
	public int buy(int price) {
		return price - (int)(price * 0.02);
	}

}
