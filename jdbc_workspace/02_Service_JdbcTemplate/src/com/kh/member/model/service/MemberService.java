package com.kh.member.model.service;

// static import는 메소드 이름까지 적어야 한다.
import static com.kh.common.JdbcTemplate.close;
import static com.kh.common.JdbcTemplate.commit;
import static com.kh.common.JdbcTemplate.getConnection;
import static com.kh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberDel;

/**
 * Service Class
 * 업무로직 담당.
 * 
 * Service
 * 1. driver class 등록
 * 2. Connection객체 생성(autoCommit false처리)
 * 3. Dao요청(Connection객체 전달)
 * 4. 트랜잭션처리(commit/rollback)
 * 5. 자원반납 (Connection)
 * 
 * Dao
 * 1. PreparedStatement객체 생성(미완성쿼리 & 값대입)
 * 2. 쿼리실행(DML - int, DQL - ResultSet) & VO객체 변환
 * 3. 자원반납 (PreparedStatement/ResultSet)
 *
 */
public class MemberService {
	
	private MemberDao memberDao = new MemberDao();

	public int insertMember(Member member) {
		// 1. Connection객체생성 & autoCommit false처리
		Connection conn = getConnection();
		// 2. Dao 업무요청
		int result = memberDao.insertMember(conn, member);
		// 3. 트랜잭션처리(commit/rollback)
		if(result > 0) commit(conn);
		else rollback(conn);
		// 4. 자원반납 (Connection)
		close(conn);
		return result;
	}

	public List<Member> selectMemberByName(String name) {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. Dao업무 요청
		List<Member> list = memberDao.selectMemberByName(conn, name);
		// 3. 자원반납
		close(conn);
		return list;
	}

	public List<Member> selectAllMember() {
		Connection conn = getConnection();
		List<Member> list = memberDao.selectAllMember(conn);
		close(conn);
		return list;
	}

	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result = memberDao.deleteMember(conn, id);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<MemberDel> selectAllMemberDel() {
		Connection conn = getConnection();
		List<MemberDel> list = memberDao.selectAllMemberDel(conn);
		close(conn);
		return list;
	}

	public Member selectOneMember(String id) {
		Connection conn = getConnection();
		Member member = memberDao.selectOneMember(conn, id);
		close(conn);
		return member;
	}

	public int updateMember(String id, String colName, String newValue) {
		Connection conn = getConnection();
		int result = memberDao.updateMember(conn, id, colName, newValue);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	
}






