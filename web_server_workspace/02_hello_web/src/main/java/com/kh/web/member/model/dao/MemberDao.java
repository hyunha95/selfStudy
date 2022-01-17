package com.kh.web.member.model.dao;

import static com.kh.web.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.web.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		String filepath = MemberDao.class.getResource("/member-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
			System.out.println("prop = " + prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 1. PreparedStatement객체 생성, 미완성쿼리 전달 및 값대입
	 * 2. 실행 executeUpdate:int
	 * 3. 자원반납
	 * 
	 */
	public int insertMember(Connection conn, Member member) {
		String sql = prop.getProperty("insertMember");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			// 1. PreparedStatement객체 생성, 미완성쿼리 전달 및 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getSsn());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getTel());
			pstmt.setString(7, member.getJob());
			pstmt.setString(8, member.getHobby());
			// 2. 실행 executeUpdate:int
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("회원가입실패!", e);
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		return result;
	}

}
