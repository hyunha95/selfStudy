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

	public List<Member> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		String sql = "select * from member order by reg_date";
		List<Member> list = new ArrayList<>();
		
		try {
			// 1. PreparedStatement 객체생성
			pstmt = conn.prepareStatement(sql);
			// 2.쿼리 실행
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				String id = rset.getString("id");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Member selectOneMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where id = ?";
		Member member = null;
		try {
			//1. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//2. 쿼리실행
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3. 자원 반납
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public List<Member> selectMemberByName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where name like ?";
		List<Member> list = new ArrayList<>();
		try {
			//1. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			//2. 쿼리 실행
			rset = pstmt.executeQuery();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, default)";
		try {
			//1. PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			//2. 쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}		
		return result;
	}

	public int updateMember(Connection conn, String id, String colName, String newValue) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update member set # = ? where id = ?";
		sql = sql.replace("#", colName);
		try {
			//1. PreparedStatement 객체 생성(미완성쿼리 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newValue);
			pstmt.setString(2, id);
			//2. 쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3. 자원반납
			close(pstmt);
		}
		
		
		return result;
	}

	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from member where id = ?";
		try {
			// 1. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// 2. 쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 3. 자원반납
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return result;
	}

	public List<Member> selectAllMemberDel(Connection conn) {
		String sql = "select * from member_del order by del_date desc";
		PreparedStatement pstmt = null;
		List<Member> list = new ArrayList<>();
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberDel member = new MemberDel();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				member.setRegDate(rset.getTimestamp("reg_date"));
				member.setDelDate(rset.getTimestamp("del_date"));
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

}
