package com.kh.member.model.dao;

import static com.kh.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberDel;


public class MemberDao {

	public int insertMember(Connection conn, Member member) {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			// 1. PreparedStatement객체 생성(미완성쿼리 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			
			// 2. 쿼리실행(DML - int, DQL - ResultSet) & VO객체 변환
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. 자원반납 (PreparedStatement/ResultSet)
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectMemberByName(Connection conn, String name) {
		String sql = "select * from member where name like ?";
		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			// 1. PreparedStatement객체 생성 & 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			// 2. 쿼리실행
			rset = pstmt.executeQuery();
			
			// 3. ResultSet처리 -> List<Member>
			while(rset.next()) {
				Member member = new Member();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				member.setRegDate(rset.getTimestamp("reg_date"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 자원반납
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public List<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by reg_date desc";
		List<Member> list = new ArrayList<>();
		
		try {
			// 1. PreparedStatment객체 생성 및 쿼리 완성
			pstmt = conn.prepareStatement(sql);
			
			// 2. 실행 및 ResultSet처리
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				// 컬럼명 대소문자 구분하지 않는다.
				String id = rset.getString("ID");
				member.setId(id);
				member.setName(rset.getString("NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setBirthday(rset.getDate("BIRTHDAY"));
				member.setEmail(rset.getString("EMAIL"));
				member.setAddress(rset.getString("ADDRESS"));				
				member.setRegDate(rset.getTimestamp("REG_DATE"));
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. 자원반납(rset, pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "delete from member where id = ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<MemberDel> selectAllMemberDel(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member_del order by del_date desc";
		List<MemberDel> list = new ArrayList<>();
		
		try {
			// 1. PreparedStatment객체 생성 및 쿼리 완성
			pstmt = conn.prepareStatement(sql);
			
			// 2. 실행 및 ResultSet처리
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MemberDel member = new MemberDel();
				// 컬럼명 대소문자 구분하지 않는다.
				member.setId(rset.getString("ID"));
				member.setName(rset.getString("NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setBirthday(rset.getDate("BIRTHDAY"));
				member.setEmail(rset.getString("EMAIL"));
				member.setAddress(rset.getString("ADDRESS"));				
				member.setRegDate(rset.getTimestamp("REG_DATE"));
				member.setDelDate(rset.getTimestamp("DEL_DATE"));
				
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3. 자원반납(rset, pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateMember(Connection conn, String id, String colName, String newValue) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "update member set # = ? where id = ?";
			sql = sql.replace("#", colName);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newValue);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectOneMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String sql = "select * from member where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				id = rset.getString("id");
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				member = new Member(id, name, gender, birthday, email, address, regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return member;
	}

}
