package com.kh.mvc.member.model.dao;

import static com.kh.mvc.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.mvc.member.model.exception.MemberException;
import com.kh.mvc.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();

	public MemberDao() {
		// /build/classes 하위에서 파일을 조회
		String filepath = MemberDao.class.getResource("/member-query.properties").getPath();
		// System.out.println(filepath);
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DQL
	 * - PreparedStatement
	 * - sql:String
	 * - ResultSet
	 * - Member VO
	 * 
	 */
	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneMember");
		ResultSet rset = null;
		Member member = null;
		
		try {
			// 1. PreparedStatement객체 생성, 미완성쿼리 전달 및 값대입
			pstmt = conn.prepareStatement(sql);
			System.out.println("pstmt = " + pstmt);
			System.out.println("sql = " + sql);
			pstmt.setString(1, memberId);
			
			// 2. 쿼리실행 executeQuery : ResultSet리턴(DQL) 
			rset = pstmt.executeQuery();
			System.out.println("rset = " + rset);
			// 3. rset -> vo
			while(rset.next()) {
				member = new Member(); // 여기서 객체를 만들면 값이없을때 null을 리턴할 수 있다.
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberRole(rset.getString("member_role"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납 생성의 역순
			close(rset);
			close(pstmt);
		}
		return member;
	}

	
	/**
	 * DML
	 * - PreparedStatement
	 * - sql:String
	 * 		insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
	 * - result:int
	 * 
	 */
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		int result = 0;
		
		try {
			// 1. PreparedStatement객체 준비 - sql 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberRole());
			pstmt.setString(5, member.getGender());
			pstmt.setDate(6, member.getBirthday());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getPhone());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getHobby());
			
			// 2. 쿼리실행 executeUpdate : int 리턴(DML)
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("회원가입 오류!", e);
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 회원정보 수정쿼리 
	 * update member set password = ?, member_name = ?, gender = ?, birthday = ?, email = ?, phone = ?, address = ?, hobby = ? where member_id = ?;
	 * 물음표 9개
	 */
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		int result = 0;
		
		try {
			// 1. PreparedStatement 객체 생성. 미완성 쿼리 전달 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getGender());
			pstmt.setDate(3, member.getBirthday());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getHobby());
			pstmt.setString(8, member.getMemberId());
			
			// 2. 쿼리실행 dml은 executeUpdate(). int 반환
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("회원정보 수정 오류", e);
		} finally {
			// 3. 자원 반납
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * delete from member where member_id = ?
	 */
	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteMember");
		
		try {
			// 1. PreparedStatement 객체 생성. 미완성 쿼리 전달 및 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			// 2. 쿼리 실행 dml. int. executeUpdate
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MemberException("회원 삭제 오류!", e);
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectAllMember(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMember");
		List<Member> list = new ArrayList<>();
		
		try {
			// 1. PreparedStatement 객체 생성.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) param.get("startNum"));
			pstmt.setInt(2, (int) param.get("endNum"));
			
			// 2.실행
			rset = pstmt.executeQuery();
			// 3. rset처리 : 하나의 레코드 -> vo객체하나 -> list에 추가
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberRole(rset.getString("member_role"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4. 자원 반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * sql
	 * 	- update member set member_role = ? where member_id = ?
	 */
	public int updateMemberRole(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateMemberRole");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberRole());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("회원권한변경 오류!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updatePassword(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePassword"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getMemberId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MemberException("비밀번호 수정 오류!", e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * select * from member where member_id like ?
	 * select * from member where member_name like ?
	 * select * from member where gender = ? 
	 */
	public List<Member> searchMember(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("searchMember");
		ResultSet rset = null;
		List<Member> list = new ArrayList<>();
		String searchType = (String) param.get("searchType");
		String searchKeyword = (String) param.get("searchKeyword");
		switch(searchType) {
			case "memberId" : sql += " member_id like '%" + searchKeyword + "%'"; break;
			case "memberName" : sql += " member_name like '%" + searchKeyword + "%'"; break;
			case "gender" : sql += " gender =  '" + searchKeyword + "'"; break;
		}
		System.out.println("sql@dao = " + sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberRole(rset.getString("member_role"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectTotalMemberCount(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectTotalMemberCount");
		ResultSet rset = null;
		int totalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next())
				totalCount = rset.getInt(1); // 컬럼인덱스 1부터
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalCount;
	}



}














