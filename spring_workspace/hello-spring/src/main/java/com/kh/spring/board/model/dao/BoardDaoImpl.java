package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Board> selectBoardList(Map<String, Object> param) {
		int offset = (int) param.get("offset");
		int limit = (int) param.get("limit");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("board.selectBoardList", null, rowBounds);
	}

	@Override
	public int selectTotalBoardCount() {
		return session.selectOne("board.selectTotalBoardCount");
	}

	@Override
	public int insertBoard(Board board) {
		return session.insert("board.insertBoard", board);
	}

	@Override
	public int insertAttachment(Attachment attach) {
		return session.insert("board.insertAttachment", attach);
	}

	@Override
	public Board selectOneBoard(int no) {
		return session.selectOne("board.selectOneBoard", no);
	}

	@Override
	public List<Attachment> selectAttachmentListByBoardNo(int boardNo) {
		return session.selectList("board.selectAttachmentListByBoardNo", boardNo);
	}

	@Override
	public Board selectOneBoardCollection(int no) {
		return session.selectOne("board.selectOneBoardCollection", no);
	}

	@Override
	public Attachment selectOneAttachment(int no) {
		return session.selectOne("board.selectOneAttachment", no);
	}
	
	
	
	
}