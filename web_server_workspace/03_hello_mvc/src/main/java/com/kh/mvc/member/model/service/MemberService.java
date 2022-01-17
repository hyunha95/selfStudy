package com.kh.mvc.member.model.service;

import static com.kh.mvc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.exception.MemberException;
import com.kh.mvc.member.model.vo.Member;

public class MemberService {

	public static final String USER_ROLE = "U";
	public static final String ADMIN_ROLE = "A";
	private MemberDao memberDao = new MemberDao();

	public Member selectOneMember(String memberId) {
		// 1. Connection객체 생성
		Connection conn = getConnection();

		// 2. Dao에 쿼리실행 요청
		Member member = memberDao.selectOneMember(conn, memberId);
		
		// 3. Connection자원반납
		close(conn);
		return member;
	}

	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		try {
			// 1. Connection객체 생성
			conn = getConnection();
			
			// 2. Dao에 쿼리실행 요청
			result = memberDao.insertMember(conn, member);
			
			// 3. 트랜잭션처리
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			// 4. Connection자원반납
			close(conn);			
		}
		return result;
	}

	public int updateMember(Member member) {
		// 1. Connection 객체 생성
		Connection conn = null;
		int result = 0;		
		try {
			conn = getConnection();
			// 2. dao에 쿼리실행 요청
			result = memberDao.updateMember(conn, member);
			// 3. 트랜잭션처리
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			// 4. 자원반납
			close(conn);
		}
		
		return result;
	}

    public int deleteMember(String memberId) {
		Connection conn = null;
		int result = 0;
		try{
			conn = getConnection();
			result = memberDao.deleteMember(conn, memberId);
			if(result == 0)
				throw new MemberException("해당 회원은 존재하지 않습니다.");
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);			
		}
		return result;
	}

	public List<Member> selectAllMember(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Member> list = memberDao.selectAllMember(conn, param);
		close(conn);
		return list;
	}

	public int updateMemberRole(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = memberDao.updateMemberRole(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public int updatePassword(Member member) {
		Connection conn = null;
		int result = 0;;
		try {
			conn = getConnection();
			result = memberDao.updatePassword(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public List<Member> searchMember(Map<String, Object> param) {
		Connection conn = getConnection();
		List<Member> list = memberDao.searchMember(conn, param);
		close(conn);
		return list;
	}

	public int selectTotalMemberCount() {
		Connection conn = getConnection();
		int totalCount = memberDao.selectTotalMemberCount(conn);
		close(conn);
		return totalCount;
	}


}















