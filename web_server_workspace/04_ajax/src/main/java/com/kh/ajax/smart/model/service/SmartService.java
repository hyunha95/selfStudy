package com.kh.ajax.smart.model.service;

import static com.kh.ajax.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.ajax.smart.model.dao.SmartDao;
import com.kh.ajax.smart.model.vo.Smart;

public class SmartService {
	
	private SmartDao smartDao = new SmartDao();

	public int insertSmart(String pname, int amount) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = smartDao.insertSmart(pname, amount, conn);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	public List<Smart> selectRecentFive(int selectAmount) {
		Connection conn = getConnection();
		List<Smart> list = smartDao.selectRecentFive(conn, selectAmount);
		close(conn);
		return list;
	}

	public List<Smart> selectRankFive(int selectAmount) {
		Connection conn = getConnection();
		List<Smart> list = smartDao.selectRankFive(conn, selectAmount);
		close(conn);
		return list;
	}

}
