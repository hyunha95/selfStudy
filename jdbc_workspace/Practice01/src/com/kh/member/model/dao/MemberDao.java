package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.member.model.vo.Member;

/**
 * Data Access Object Class
 * Database에 접근, 쿼리실행 및 결과를 담당하는 클래스
 * 
 * jdbc api사용
 * - 구현체 ojdbc8.jar 필수
 * 
 * DML : Connection, PreparedStatement 사용, 결과 int
 * DQL : Connection, PreparedStatement 사용, 결과 Resultset
 * 
 * @author hyunha
 *
 */
public class MemberDao {
	
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "student";
	private String password = "student";

	public int insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?,?,?,default)";
		int result = 0;
		
		try {
			// 1. driver class 등록(프로그램 실행시 1회)
			Class.forName(driverClass);
			
			// 2. Connection객체 생성(url, user, password) & auto-commit 설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement객체 생성(미완성쿼리 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setTimestamp(6, member.getRegDate());
			
			// 4. 쿼리실행(DML : executeUpdate) & 결과값(int) 처리
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) conn.commit();
			else conn.rollback();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 생성 역순 반납
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from member where id = ?";
		try {
			// 1. driverClass 등록
			Class.forName(driverClass);
			// 2. Connection객체 생성 & auto-commit 설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement 객체생성(미완성쿼리& 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// 4. 쿼리 실행
			result = pstmt.executeUpdate();
			// 5. 트랜잭션 처리
			if(result > 0) conn.commit();
			else conn.rollback();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}








