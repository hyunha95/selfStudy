package com.kh.member.controller;

import java.util.List;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

/**
 * controller class
 * 프로그램 실행 제어권을 가진 클래스
 * 
 */
public class MemberController {

	private MemberDao memberDao = new MemberDao();
	
	public int insertMember(Member member) {
		//1. dao메소드 호출
		int result = memberDao.insertMember(member);
		//2. 리턴값 다시 view단 전달
		return result;
	}

	public int deleteMember(String id) {
		// 1. dao메소드 호출
		int result = memberDao.deleteMember(id);
		// 2. view단 리턴
		return result;
	}

	public List<Member> selectAllMember() {
		return memberDao.selectAllMember();
	}

	public Member selectOneMember(String id) {
		return memberDao.selectOneMember(id);
	}
	
	public List<Member> selectMemberByName(String name) {
		// 1. MemberDao에게 이름과 일치하는 회원정보 조회 : n행
		List<Member> list = memberDao.selectMemberByName(name);
		// 2. MemberMenu에게 결과값 반환
		return list;
	}
	
	public int updateMemberName(String id, String newName) {
		return memberDao.updateMemberName(id, newName);
	}

	public int updateMemberEmail(String id, String newEmail) {
		return memberDao.updateMemberEmail(id, newEmail);
	}

	public int updateMemberAddress(String id, String newAddress) {
		return memberDao.updateMemberAddress(id, newAddress);
	}
	

}
