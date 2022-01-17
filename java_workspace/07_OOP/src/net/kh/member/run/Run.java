package net.kh.member.run;

import net.kh.member.model.Member;

public class Run {

	public static void main(String[] args) {
		Member member = new Member();
		
		member.setMemberId("hyunha");
		member.setMemberPwd("1234");
		member.setMemberName("노현하");
		member.setAge(27);
		member.setGender('남');
		member.setPhone("010");
		member.setEmail("yaa4500");
		
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPwd());
		System.out.println(member.getMemberName());
		System.out.println(member.getAge());
		System.out.println(member.getGender());
		System.out.println(member.getPhone());
		System.out.println(member.getEmail());
	}
}
