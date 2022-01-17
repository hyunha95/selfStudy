package com.kh.mvc.board.model.dao;

import static com.kh.mvc.common.JdbcTemplate.*;

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

import com.kh.mvc.board.model.exception.BoardException;
import com.kh.mvc.board.model.vo.Attachment;
import com.kh.mvc.board.model.vo.Board;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	/**
	 * board-query.properties 파일의 key=value 쿼리를 가져온다.
	 *  - 클래스객체를 통해 build-path에 배포된 파일에 접근할 것! 
	 */
	public BoardDao() {
		// /build/classes 하위에서 파일을 조회
		String filepath = BoardDao.class.getResource("/board-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * select * from(select row_number() over(order by no desc) rnum, b.* from  board b) where rnum between ? and ? 
	 */
	public List<Board> selectAllBoard(Connection conn, Map<String, Object> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllBoard");
		List<Board> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) param.get("startNum"));
			pstmt.setInt(2, (int) param.get("endNum"));
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board();
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setReadCount(rset.getInt("read_count"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setAttachCount(rset.getInt("attach_count"));
				list.add(board);
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

	public int selectTotalBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalContent = 0;
		String sql = prop.getProperty("selectTotalBoardCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalContent = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalContent;
	}

	/**
	 * insert into board (no, title, writer, content) values(seq_board_no.nextval, ?, ?, ?)
	 * @param conn
	 * @param board
	 * @return
	 */
	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new BoardException("게시글 등록 오류!", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectLastBoardNo(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectLastBoardNo");
		ResultSet rset = null;
		int boardNo = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				boardNo = rset.getInt(1);
			}
		} catch (SQLException e) {
			throw new BoardException("최근 게시글 번호 조회 오류!", e);
		} finally {
			close(pstmt);
		}
		return boardNo;
	}
	
	public int insertAttachment(Connection conn, Attachment attach) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attach.getBoardNo());
			pstmt.setString(2, attach.getOriginalFilename());
			pstmt.setString(3, attach.getRenamedFilename());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new BoardException("첨부파일 등록 오류!", e);
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public Board selectOneBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneBoard");
		ResultSet rset = null;
		Board board = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setReadCount(rset.getInt("read_count"));
				board.setRegDate(rset.getDate("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return board;
	}

}
