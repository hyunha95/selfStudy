package member.controller;

import member.model.vo.other.Member;

public class MemberManager{

	public static final int MAX_MEMBER = 40;
	Member[] memberArr = new Member[MAX_MEMBER];
	int memberIndex = 0; // 추가할 요소의 인덱스 && 이제까지 입력된 객체수
	
	/**
	 * 다형성
	 * 
	 * Member m = new Silver();
	 * Member m = new Gold();
	 * Member m = new Vip();
	 * Member m = new VVip();
	 * 
	 */
	public void insertMember(Member m) {
		this.memberArr[memberIndex++] = m;
	}
	
	//인터페이스:
	//Member타입이 Buyable인터페이스를 구현하고 있으므로, 별도의 형변환 없이 buy메소드 사용가능
	public void printBuyInfo(int price) {
		for(int i = 0; i < memberIndex; i++) {
			System.out.println(memberArr[i].getGrade() + "등급회원" + memberArr[i].getName() + "는" + price + "원 상품을" +
								memberArr[i].buy(price) + "원에 구매합니다.");
		}
	}

	public void printData() {
		System.out.println("----------------------------------------<<회원정보>>-----------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-15s\n", "이름","등급","포인트","이자포인트");
		System.out.println("------------------------------------------------------------------------------------------------");
	
		for(int i=0; i<memberIndex; i++){
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", memberArr[i].getName(), memberArr[i].getGrade(), memberArr[i].getPoint(), memberArr[i].getInterestPoint());
		}
		System.out.println("------------------------------------------------------------------------------------------------");
	}
}

/* 다형성 적용 전
	public static final int MAX_MEMBER_COUNT = 10;
	Silver[] s= new Silver[MAX_MEMBER_COUNT];
	Gold[] g = new Gold[MAX_MEMBER_COUNT];
	Vip[] v = new Vip[MAX_MEMBER_COUNT];
	VVip[] vv = new VVip[MAX_MEMBER_COUNT];
	
	int silverIndex = 0;
	int goldIndex = 0;
	int vipIndex = 0;
	int vvipIndex = 0;
	
	
	public void silverInsert(Silver s) {
		this.s[silverIndex++] = s;
	}
	public void goldInsert(Gold g) {
		this.g[goldIndex++] = g;
	}
	public void vipInsert(Vip v){
		this.v[vipIndex++] =  v;
	}
	public void vvipInsert(VVip vv){
		this.vv[vvipIndex++] =  vv;
	}
	
	public void printData() {
		System.out.println("----------------------------------------<<회원정보>>-----------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-15s\n", "이름","등급","포인트","이자포인트");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(int i=0; i<silverIndex;i++) {
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", s[i].getName(), s[i].getGrade(), s[i].getPoint(), s[i].getEjapoint());			
		}
		for(int i=0; i<goldIndex;i++) {
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", g[i].getName(), g[i].getGrade(), g[i].getPoint(), g[i].getEjapoint());
		}
		for(int i=0; i<vipIndex; i++){
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", v[i].getName(), v[i].getGrade(), v[i].getPoint(), v[i].getEjapoint());
		}
		for(int i=0; i<vvipIndex; i++){
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", vv[i].getName(), vv[i].getGrade(), vv[i].getPoint(), vv[i].getEjapoint());
		}
	}
 */
