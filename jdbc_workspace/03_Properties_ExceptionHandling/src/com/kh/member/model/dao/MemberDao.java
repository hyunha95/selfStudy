package com.kh.member.model.dao;

import static com.kh.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.exception.MemberDataNotValidException;
import com.kh.member.model.exception.MemberException;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberDel;


public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		final String sqlConfigpath = "resources/member-query.properties";
		try {
			prop.load(new FileReader(sqlConfigpath));
			System.out.println("prop = " + prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertMember(Connection conn, Member member) {
		String sql = prop.getProperty("insertMember");
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
			String message = "회원 가입 오류!";
			if(e.getMessage().contains("STUDENT.CK_MEMBER_GENDER")) {
				message += String.format("(성별은 M 또는 F 값만 가능합니다. - %s)", member.getGender());
				throw new MemberDataNotValidException(message, e);
			}
			else
				throw new MemberException(message, e);
		} finally {
			// 3. 자원반납 (PreparedStatement/ResultSet)
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectMemberByName(Connection conn, String name) {
		String sql = prop.getProperty("selectMemberByName");
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
				member.setId(rset.getString("idddd"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				member.setRegDate(rset.getTimestamp("reg_date"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			// 예외처리공식 : 발생한 예외를 프로그램 흐름을 제어하는 곳까지 던져준다.
			// UncheckedException이면서 업무흐름을 설명가능한 구체적 예외로 변경해서 던져준다.
			throw new MemberException("회원 이름 검색 오류!(" + e.getMessage() + ")", e);
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
		String sql = prop.getProperty("selectAllMember");
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
			String sql = prop.getProperty("deleteMember"); 
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
		String sql = prop.getProperty("selectAllMemberDel");
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
			String sql = prop.getProperty("updateMember");
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
		String sql = prop.getProperty("selectOneMember");

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
