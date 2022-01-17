package com.kh.spring.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
}
