package com.kh.spring.memo.model.service;

import java.util.List;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoService {

	List<Memo> selectMemoList();

	int insertMemo(Memo memo);

	int deleteMemo(int no);

	Memo selectOneMemo(int no);

}
