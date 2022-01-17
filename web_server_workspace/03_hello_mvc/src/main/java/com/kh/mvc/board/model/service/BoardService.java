package com.kh.mvc.board.model.service;

import static com.kh.mvc.common.JdbcTemplate.close;
import static com.kh.mvc.common.JdbcTemplate.commit;
import static com.kh.mvc.common.JdbcTemplate.getConnection;
import static com.kh.mvc.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.mvc.board.model.dao.BoardDao;
import com.kh.mvc.board.model.vo.Attachment;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.board.model.vo.BoardComment;

public class BoardService {

	private BoardDao boardDao = new BoardDao();
	
	public List<Board> selectAllBoard(Map<String, Integer> param) {
		Connection conn = getConnection();
		List<Board> list = boardDao.selectAllBoard(conn, param);
		close(conn);
		return list;
	}

	public int selectTotalBoardCount() {
		Connection conn = getConnection();
		int totalCount = boardDao.selectTotalBoardCount(conn);
		close(conn);
		return totalCount;
	}

	/**
	 * Transaction
	 * 
	 * - insertBoard
	 * - insertAttachment * n
	 * 
	 * 
	 * 
	 */
	public int insertBoard(Board board) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = boardDao.insertBoard(conn, board);
			
			// 방금 insert된 boardNo 조회 : select seq_board_no.currval from dual
			int boardNo = boardDao.selectLastBoardNo(conn);
			System.out.println("[BoardService] boardNo = " + boardNo);
			board.setNo(boardNo); // servlet에서 참조할 수 있도록한다.
			
			List<Attachment> attachments = board.getAttachments();
			if(attachments != null) {
				// insert into attachment values(seq_attachment_no.nextval, 0, ?, ?, default)
				for(Attachment attach : attachments) {
					attach.setBoardNo(boardNo); // FK컬럼값 설정(중요)
					result = boardDao.insertAttachment(conn, attach);
				}
			}
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public Board selectOneBoard(int no) {
		Connection conn = getConnection();
		Board board = boardDao.selectOneBoard(conn, no);
		List<Attachment> attachments = boardDao.selectAttachmentByBoardNo(conn,no);
		board.setAttachments(attachments);
		close(conn);
		return board;
	}

	public Board selectOneBoardAttachments(int no) {
		Connection conn = getConnection();
		Board board = boardDao.selectOneBoardAttachments(conn, no);
		close(conn);
		return board;
	}

	public int updateReadCount(int no) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = boardDao.updateReadCount(conn, no);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public Attachment selectOneAttachment(int no) {
		Connection conn = getConnection();
		Attachment attach = boardDao.selectOneAttachment(conn, no);
		close(conn);
		return attach;
	}

	public int updateBoard(Board board) {
		Connection conn = null;
		int result = 0;
		try {
			conn = getConnection();
			// 트랜잭션처리할 코드
			// 1. board update
			result = boardDao.updateBoard(conn, board);
			
			// 2. attachment insert
			List<Attachment> attachments = board.getAttachments();
			if(attachments != null && !attachments.isEmpty()) {
				for(Attachment attach : attachments) {
					result = boardDao.insertAttachment(conn, attach);
				}
			}		
			
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;

	}

	public int deleteAttachment(int delFileNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = boardDao.deleteAttachment(conn, delFileNo);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		}
		return result;
	}

	 public int insertBoardComment(BoardComment bc) {
		 Connection conn = null;
		 int result = 0;
		 try {
			conn = getConnection();
			result = boardDao.insertBoardComment(conn, bc);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		 return result;
	 }

	public List<BoardComment> selectBoardCommentList(int boardNo) {
		Connection conn = getConnection();
		List<BoardComment> commentList = boardDao.selectBoardCommentList(conn, boardNo);
		close(conn);
		return commentList;
	}


}
