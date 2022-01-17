package member.model.vo;

import member.model.vo.other.Member;

public class Gold extends Member{

	public Gold() {
		
	}

	public Gold(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getInterestPoint() {
		return super.getPoint() * 0.05;
	}
	
	@Override
	public int buy(int price) {
		return price - (int)(price * 0.05);
	}
	

	
	
}
