package member.model.vo;

import member.model.vo.other.Member;

public class Vip extends Member{

	public Vip() {

	}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public double getInterestPoint() {
		return  super.getPoint() * 0.1;
	}
	
	@Override
	public int buy(int price) {
		return price - (int)(price * 0.1);
	}
	
	
}

