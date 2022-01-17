package member.model.vo;

import member.model.vo.other.Member;

public class VVip extends Member{

	public VVip() {

	}
	
	public VVip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getInterestPoint() {
		return  super.getPoint() * 0.15;
	}
	
	@Override
	public int buy(int price) {
		return price - (int)(price * 0.15);
	}
	
}
