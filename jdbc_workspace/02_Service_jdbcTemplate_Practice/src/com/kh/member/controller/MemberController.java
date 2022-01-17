package com.kh.member.controller;

import java.util.List;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

public class MemberController {

	private MemberService memberService = new MemberService();
	
	public List<Member> selectAllMember() {
		return memberService.selectAllMember();
	}

	public Member selectOneMember(String id) {
		return memberService.selectOneMember(id);
	}

	public List<Member> selectMemberByName(String name) {
		return memberService.selectMemberByName(name);
	}

	public int insertMember(Member member) {
		return memberService.insertMemeber(member);
	}

	public int updateMember(String id, String colName, String newValue) {
		return memberService.updateMember(id, colName, newValue);
	}

	public int deleteMember(String id) {
		return memberService.deleteMember(id);
	}

	public List<Member> selectAllMemberDel() {
		return memberService.selectAllMemberDel();
	}

}
