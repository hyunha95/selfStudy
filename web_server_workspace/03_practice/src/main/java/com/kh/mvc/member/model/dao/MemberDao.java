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
		System.out.println(filepath);
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		System.out.println(sql);
		ResultSet rset = null;
		Member member = null;
		
		try {
			// 1. PreparedStatement 객체 생성, 미완성쿼리 전달 및 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			// 2. 쿼리실행 executeQuery : ResultSet 리턴
			rset = pstmt.executeQuery();
			
			// 3. rset -> vo
			while(rset.next()) {
				member = new Member();
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
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		int result = 0;
		
		try {
			// 1. PreparedStatement 객체 생성. 미완성쿼리 전달 & 값대입
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
			
			// 2. 쿼리실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MemberException("회원가입 오류!", e);
		} finally {
			close(pstmt);
		}
		// 3. 자원반납
		return result;
	}

	/**
	 * 회원정보 수정쿼리
	 * update member set password = ?, member_name = ?, gender = ?, birthday = ?,  email = ?, phone = ?, address = ?, hobby = ? where member_id = ?
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
			
			// 2. 쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * select * from(select row_number () over (order by enroll_date desc) rnum, m.* from member m) where rnum between ? and ?
	 */
	public List<Member> selectAllMember(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		List<Member> list = new ArrayList<>();
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMember"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) param.get("startNum"));
			pstmt.setInt(2, (int) param.get("endNum"));
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

	/**
	 * update member set member_role = ? where member_id = ?
	 * @param conn
	 * @param member
	 * @return
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

	/**
	 * delete from member where member_id ?
	 */
	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * update member set password = ? where member_id = ?
	 */
	public int updatePassword(Connection conn, Member loginMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updatePassword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginMember.getPassword());
			pstmt.setString(2, loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int totalCount = 0;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTotalMemberCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				totalCount = rset.getInt(1); // 컬럼인덱스 1부터
			}
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


















