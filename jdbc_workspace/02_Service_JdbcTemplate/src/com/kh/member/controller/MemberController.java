package com.kh.member.controller;

import java.util.List;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberDel;

/**
 * 
 * 사용자요청을 최초를 받아 service단에 업무를 분담, 처리결과를 view단으로 전달하는 역할 
 *
 */
public class MemberController {
	
	private MemberService memberService = new MemberService();

	public int insertMember(Member member) {
		// 1. service단 업무요청
		int result = memberService.insertMember(member);
		// 2. view단 처리결과 전달
		return result;
	}

	public List<Member> selectMemberByName(String name) {
		return memberService.selectMemberByName(name);
	}

	public List<Member> selectAllMember() {
		List<Member> list = memberService.selectAllMember();
		return list;
	}
	
	public int deleteMember(String id) {
		// 1. memberService객체에 member객체 delete요청
		int result = memberService.deleteMember(id);
		
		// 2. MemberMenu에 결과값 반환
		return result; 
	}

	public List<MemberDel> selectAllMemberDel() {
		return memberService.selectAllMemberDel();
	}

	public Member selectOneMember(String id) {
		// 1. memberService에게 id와 일치하는 회원정보 조회 : 1행 - Member객체, 0행 - null
		Member member = memberService.selectOneMember(id);
		
		// 2. MemberMenu에게 결과값반환
		return member;
	}

	public int updateMember(String id, String colName, String newValue) {
		return memberService.updateMember(id, colName, newValue);
	}


}







