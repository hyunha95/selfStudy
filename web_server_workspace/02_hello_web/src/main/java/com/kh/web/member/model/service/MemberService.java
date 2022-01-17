package com.kh.web.member.model.service;

import static com.kh.web.common.JdbcTemplate.*;

import java.sql.Connection;

import com.kh.web.common.JdbcTemplate;
import com.kh.web.member.model.dao.MemberDao;
import com.kh.web.member.model.vo.Member;

/**
 * Dao 요청
 * 	- Connection객체 생성
 *
 */
public class MemberService {
	
	private MemberDao memberDao = new MemberDao();

	/**
	 * DML
	 * 1. Connection생성
	 * 2. Dao 메소드호출(Connection 전달)
	 * 3. transaction처리
	 * 4. Connection 자원반납
	 * 
	 */
	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		try {
			conn = getConnection();
			result = memberDao.insertMember(conn, member);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);	
			throw e;
		}
		close(conn);
		return result;
	}
}
