package com.kh.spring.board.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> selectBoardList(Map<String, Object> param) {
		return boardDao.selectBoardList(param);
	}

	@Override
	public int selectTotalBoardCount() {
		return boardDao.selectTotalBoardCount();
	}

//	@Transactional(
//			propagation=Propagation.REQUIRED,
//			isolation = Isolation.READ_COMMITTED,
//			rollbackFor=Exception.class)
	@Override
	public int insertBoard(Board board) {
		int result = boardDao.insertBoard(board);
		log.debug("boardNo = {}", board.getNo());
		List<Attachment> attachments = board.getAttachments();
		if(attachments != null) {
			for(Attachment attach : attachments) {
				// fk컬럼 boardNo값 설정
				attach.setBoardNo(board.getNo());
				result = insertAttachment(attach);
			}
		}
		return result;
	}

//	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertAttachment(Attachment attach) {
		return boardDao.insertAttachment(attach);
		
	}

	@Override
	public Board selectOneBoard(int no) {
		// 1.board테이블 조회
		Board board = boardDao.selectOneBoard(no);
		
		// 2.attachment테이블 조회
		List<Attachment> attachments = boardDao.selectAttachmentListByBoardNo(no);
		
		// 3. 합치기
		board.setAttachments(attachments);
		
		return board;
	}

	@Override
	public Board selectOneBoardCollection(int no) {
		return boardDao.selectOneBoardCollection(no);
	}

	@Override
	public Attachment selectOneAttachment(int no) {
		return boardDao.selectOneAttachment(no);
	}
	
	
	
	
}
