package com.kh.member.controller;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberController {
	
	private MemberDao memberDao = new MemberDao();

	public int insertMember(Member member) {
		int result = memberDao.insertMember(member);
		return result;
	}
	
	public int deleteMember(String id) {
		int result = memberDao.deleteMember(id);
		return result;
	}
}
