package com.spring.board.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.member.model.dao.MemberDao;
import com.spring.board.member.model.vo.Member;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	// 회원가입 시, member/authority에 각각 insert해야한다. (transaction 처리필수)
	@Override
	public int insertMember(Member member) {
		int result = memberDao.insertMember(member);
		result = memberDao.insertAuthority(member);
		return result;
	}
	
	
}
