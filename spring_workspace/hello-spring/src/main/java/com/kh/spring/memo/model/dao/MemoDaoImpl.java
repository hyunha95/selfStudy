package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemoDaoImpl implements MemoDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Memo> selectMemoList() {
		log.debug("Dao 주업무");
		return session.selectList("memo.selectMemoList");
	}

	@Override
	public int insertMemo(Memo memo) {
		return session.insert("memo.insertMemo", memo);
	}

	@Override
	public int deleteMemo(int no) {
		return session.delete("memo.deleteMemo", no);
	}

	@Override
	public Memo selectOneMemo(int no) {
		return session.selectOne("memo.selectOneMemo", no);
	}
	
	
}
