package com.kh.member.model.service;

import static com.kh.common.JdbcTemplate.close;
import static com.kh.common.JdbcTemplate.getConnection;
import static com.kh.common.JdbcTemplate.commit;
import static com.kh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	
	public List<Member> selectAllMember() {
		//1. Connection 생성
		Connection conn = getConnection();
		//2. Dao 호출
		List<Member> list = memberDao.selectAllMember(conn);
		//3 자원반납
		close(conn);
		return list;
	}

	public Member selectOneMember(String id) {
		//1. Connection 생성
		Connection conn = getConnection();
		//2. Dao호출
		Member member = new Member();
		member = memberDao.selectOneMember(conn, id);
		//3. 자원반납
		close(conn);
		return member;
	}

	public List<Member> selectMemberByName(String name) {
		//1. Connection 생성
		Connection conn = getConnection();
		//2. Dao 호출
		List<Member> list = memberDao.selectMemberByName(conn, name);
		//3. 자원반납
		close(conn);
		return list;
	}

	public int insertMemeber(Member member) {
		// 1. Connection 객체생성
		Connection conn = getConnection();
		//2. Dao 호출
		int result = memberDao.insertMember(conn, member);
		//3. 트랜잭션처리(commit/rollback)
		if(result > 0) commit(conn);
		else rollback(conn);
		//4. 자원반납
		close(conn);
		return result;
	}

	public int updateMember(String id, String colName, String newValue) {
		// 1. Connection 객체생성 & autoCommit false처리
		Connection conn = getConnection();
		// 2. Dao 업무요청
		int result = memberDao.updateMember(conn, id, colName, newValue);
		// 3. 트랜잭션처리(commit/rollback)
		commit(conn);
		rollback(conn);
		// 4. 자원반납
		close(conn);
		return result;
	}

	public int deleteMember(String id) {
		// 1. Connection 객체 생성
		Connection conn = getConnection();
		// 2. Dao호출
		int result = memberDao.deleteMember(conn, id);
		// 3. 자원반납
		close(conn);
		return result;
	}

	public List<Member> selectAllMemberDel() {
		// 1. Connection 객체생성
		Connection conn = getConnection();
		// 2. Dao 호출
		List<Member> list = memberDao.selectAllMemberDel(conn);
		// 3. 자원반납
		close(conn);
		return list;
	}

}
