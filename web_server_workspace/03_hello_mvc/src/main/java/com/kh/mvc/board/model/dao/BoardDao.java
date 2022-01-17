package com.kh.mvc.board.model.dao;

import static com.kh.mvc.common.JdbcTemplate.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
import com.kh.mvc.board.model.vo.BoardComment;

public class BoardDao {

	private Properties prop = new Properties();
	
	public BoardDao() {
		// /build/classes 하위에서 파일을 조회
		File file = new File(BoardDao.class.getResource("/board-query.properties").getPath());
		try {
			prop.load(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Board> selectAllBoard(Connection conn, Map<String, Integer> param) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Board> list = new ArrayList<>();
		String sql = prop.getProperty("selectAllBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, param.get("startNum"));
			pstmt.setInt(2, param.get("endNum"));
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board();
				board.setNo(rset.getInt("no")); // number
				board.setTitle(rset.getString("title")); // varchar2, char
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setReadCount(rset.getInt("read_count"));
				board.setRegDate(rset.getDate("reg_date"));
				
				board.setCommentCount(rset.getInt("comment_count"));
				board.setAttachCount(rset.getInt("attach_count"));
				list.add(board);
			}
		} catch (SQLException e) {
			throw new BoardException("게시글 목록 조회 오류!", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * select count(*) from board
	 */
	public int selectTotalBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTotalBoardCount");
		int totalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()){
				totalCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalCount;
	}

	/**
	 * insert into board(title, writer, content) values(?, ?, ?)
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
			throw new BoardException("게시물 등록 오류!", e);
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
			throw new BoardException("최근 게시글번호 조회 오류!", e);
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


	/**
	 * select * from board where no = ?
	 */
	public Board selectOneBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneBoard");
		Board board = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = 
						new Board(rset.getInt("no"), rset.getString("title"), 
								rset.getString("writer"), rset.getString("content"), 
								rset.getInt("read_count"), rset.getDate("reg_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return board;
	}

	public List<Attachment> selectAttachmentByBoardNo(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectAttachmentByBoardNo");
		ResultSet rset = null;
		List<Attachment> attachments = new ArrayList<>();
		
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(sql);
			//쿼리문미완성
			pstmt.setInt(1, boardNo);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Attachment attach = new Attachment();
				attach.setNo(rset.getInt("no"));
				attach.setBoardNo(rset.getInt("board_no"));
				attach.setOriginalFilename(rset.getString("original_filename"));
				attach.setRenamedFilename(rset.getString("renamed_filename"));
				attach.setRegDate(rset.getDate("reg_date"));
				attachments.add(attach);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return attachments;

	}


	public Board selectOneBoardAttachments(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneBoardAttachements");
		Board board = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setReadCount(rset.getInt("read_count"));
				board.setRegDate(rset.getDate("reg_date"));
				
				int attachNo = rset.getInt("attach_no");
				if(attachNo != 0) {
					// 첨부파일일 있는 경우 1행 또는 2행이다.
					List<Attachment> attachments = new ArrayList<>();
					do {
						Attachment attach = new Attachment();
						attach.setNo(rset.getInt("attach_no"));
						attach.setBoardNo(rset.getInt("board_no"));
						attach.setOriginalFilename(rset.getString("original_filename"));
						attach.setRenamedFilename(rset.getString("renamed_filename"));
						attach.setRegDate(rset.getDate("reg_date"));
						attachments.add(attach);
					} while (rset.next());
					board.setAttachments(attachments);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return board;
	}


	public int updateReadCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new BoardException("조회수 증가 처리 오류!", e);
		} finally {
			close(pstmt);
		}
		return result;
		
	}


	public Attachment selectOneAttachment(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneAttachment");
		ResultSet rset = null;
		Attachment attach = null;
		
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(sql);
			//쿼리문미완성
			pstmt.setInt(1, no);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				attach = new Attachment();
				attach.setNo(rset.getInt("no"));
				attach.setBoardNo(rset.getInt("board_no"));
				attach.setOriginalFilename(rset.getString("original_filename"));
				attach.setRenamedFilename(rset.getString("renamed_filename"));
				attach.setRegDate(rset.getDate("reg_date"));
			}
		}catch(Exception e){
			throw new BoardException("첨부파일 조회 오류!", e);
		}finally{
			close(rset);
			close(pstmt);
		}
		return attach;

	}


	public int updateBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		int result = 0;
				
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(sql);
			//쿼리문미완성
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			result = pstmt.executeUpdate();
		}catch(Exception e){
			throw new BoardException("첨부파일 조회 오류!", e);
		}finally{
			close(pstmt);
		}
		return result;
	}


	public int deleteAttachment(Connection conn, int delFileNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delFileNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoardComment");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc.getCommentLevel()); // 1, 2
			pstmt.setString(2, bc.getWriter());    // memberId
			pstmt.setString(3, bc.getContent());   // ..
			pstmt.setInt(4, bc.getBoardNo());      // boardNo
//			pstmt.setInt(5, bc.getCommentRef());   // 0
//			pstmt.setInt(5, bc.getCommentRef() == 0 ? null : bc.getCommentRef());   // NullPointerException
			pstmt.setObject(5, bc.getCommentRef() == 0 ? null : bc.getCommentRef()); // 이걸로 써야함
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public List<BoardComment> selectBoardCommentList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectBoardCommentList");
		ResultSet rset = null;
		List<BoardComment> commentList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setNo(rset.getInt("no"));
				bc.setCommentLevel(rset.getInt("comment_level"));
				bc.setWriter(rset.getString("writer"));
				bc.setContent(rset.getString("content"));
				bc.setBoardNo(rset.getInt("board_no"));
				bc.setCommentRef(rset.getInt("comment_ref")); // 댓글인 경우 null이고, 이는 0으로 치환된다.
				bc.setRegDate(rset.getDate("reg_date"));
				commentList.add(bc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return commentList;
	}

}
