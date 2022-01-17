package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kh.member.model.vo.Member;

/**
 * Data Access Object Class
 * Database에 접근, 쿼리실행 및 결과를 담당하는 클래스
 * 
 * jdbc api 사용
 * -구현체 ojdbc8.jar 필수
 * 
 * DML : Connection, PreparedStatement 사용, 결과값 int
 * DQL : Connection, PreparedStatement 사용, 결과값 ResultSet
 *
 */
public class MemberDao {
	
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속프로토콜@url:port:sid
	private String user = "student";
	private String password = "student";

	public int insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		int result = 0;
		
		try {
			// 1. driver class 등록(프로그램 실행시 1회)
			Class.forName(driverClass);
			
			// 2. Connection객체 생성(url, user, password) & auto-commit설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement객체 생성(미완성쿼리 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			
			// 4. 쿼리실행(DML: executeUpdate) & 결과값(int) 처리
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) conn.commit();
			else conn.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 생성 역순 반납
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id = ?";
		int result = 0;
		
		try {
			// 1. driver class 등록(프로그램 실행시 1회) 
			// 클래스객체등록
			Class.forName(driverClass);
			
			// 2. Connection객체 생성(url, user, password) & auto-commit설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			// 3. PreparedStatement객체 생성(미완성쿼리 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 4. 쿼리실행(DML: executeUpdate) & 결과값(int) 처리
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션 처리
			if(result > 0) conn.commit();
			else conn.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 생성 역순 반납
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Member> selectAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by reg_date";
		List<Member> list = new ArrayList<>(); // 결과집합 0행인 경우도 null이 아닌 빈 list객체 반환 
		
		try {
			// 1. driverClass등록 : 클래스객체 생성
			Class.forName(driverClass);
			
			// 2. Connection객체생성
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. PreparedStatement객체 생성(미완성 쿼리전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			
			// 4. 쿼리실행 (ResultSet객체 반환)
			// 결과집합이 0행이어도 rset이 null이 아니다.
			rset = pstmt.executeQuery();
			
			// 5. ResultSet객체 -> List<Member> 변환
			// rset에 한행씩 접급해서 Member객체변환 -> list추가
			while(rset.next()) {
				// 한행(record) -> Member객체
				String id = rset.getString("id"); // 현재행의 id컬럼(문자형)
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				Member member = new Member(id, name, gender, birthday, email, address, regDate);
				list.add(member);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 (생성역순 : ResultSet -> PreparedStatement -> Connection)
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println("list@dao = " + list);
		return list;
	}

	
	public Member selectOneMember(String id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null; // 조회된 결과가 없으면 null을 리턴
		
		try {
			// 1. driverClass 등록
			Class.forName(driverClass);
			// 2. Connection객체 생성
			conn = DriverManager.getConnection(url, user, password);
			// 3. PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// 4. 쿼리실행
			rset = pstmt.executeQuery();
			
			// 5. ResultSet -> Member변환
			if(rset.next()) {
				member = new Member();
				member.setId(rset.getString(1));
				member.setName(rset.getString(2));
				member.setGender(rset.getString(3));
				member.setBirthday(rset.getDate(4));
				member.setEmail(rset.getString(5));
				member.setAddress(rset.getString(6));
				member.setRegDate(rset.getTimestamp(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	
	public List<Member> selectMemberByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Member> list = new ArrayList<>();
		String sql = "select * from member where name like ?"; // '%길동%'
		
		
		try {
			// 1. jdbc driver클래스 등록
			Class.forName(driverClass);
			
			// 2. Connection객체 생성
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			// 4. 쿼리 실행, 결과 처리(ResultSet)
			// 0행이상의 결과행을 가지고 있다.
			rset = pstmt.executeQuery();
			
			// 5. ResultSet -> 자바객체(List<Member>)
			// rset.next():boolean 다음행 존재여부. 포인터를 다음행으로 이동
			while(rset.next()) {
				// 한행이 vo객체 하나와 매칭된다.
				String id = rset.getString("id");
				name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				Member member = new Member(id, name, gender, birthday, email, address, regDate);
				
				//list에 vo추가
				list.add(member);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 생성 역순
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	public int updateMemberName(String id, String newName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 1. jdbc driver class 등록(프로그램 최초 1회 등록) 
			Class.forName(driverClass);
		
			// 2. Connection객체 생성(url, user, password)
			// autocommit 설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // application에서 직접 제어
			
			// 3. PreparedStatement객체 생성 : 사용자입력값 전달
			String sql = "update member set name = ? where id = ?"; // 세미콜론 찍지 말것.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setString(2, id);
			
			// 4. 쿼리실행 및 결과 int 처리
			result = pstmt.executeUpdate(); // 처리된 행의 개수를 리턴
			
			// 5. 트랜잭션 처리
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 객체생성의 역순으로 반환
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public int updateMemberEmail(String id, String newEmail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 1. jdbc driver class 등록(프로그램 최초 1회 등록) 
			Class.forName(driverClass);
		
			// 2. Connection객체 생성(url, user, password)
			// autocommit 설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // application에서 직접 제어
			
			// 3. PreparedStatement객체 생성 : 사용자입력값 전달
			String sql = "update member set email = ? where id = ?"; // 세미콜론 찍지 말것.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newEmail);
			pstmt.setString(2, id);
			
			// 4. 쿼리실행 및 결과 int 처리
			result = pstmt.executeUpdate(); // 처리된 행의 개수를 리턴
			
			// 5. 트랜잭션 처리
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 객체생성의 역순으로 반환
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	public int updateMemberAddress(String id, String newAddress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 1. jdbc driver class 등록(프로그램 최초 1회 등록) 
			Class.forName(driverClass);
		
			// 2. Connection객체 생성(url, user, password)
			// autocommit 설정
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // application에서 직접 제어
			
			// 3. PreparedStatement객체 생성 : 사용자입력값 전달
			String sql = "update member set address = ? where id = ?"; // 세미콜론 찍지 말것.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newAddress);
			pstmt.setString(2, id);
			
			// 4. 쿼리실행 및 결과 int 처리
			result = pstmt.executeUpdate(); // 처리된 행의 개수를 리턴
			
			// 5. 트랜잭션 처리
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납 : 객체생성의 역순으로 반환
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}


}














