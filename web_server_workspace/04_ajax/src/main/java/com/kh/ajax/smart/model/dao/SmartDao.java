package com.kh.ajax.smart.model.dao;

import static com.kh.ajax.common.JdbcTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.ajax.smart.model.vo.Smart;

public class SmartDao {

	private Properties prop = new Properties();
	
	public SmartDao() {
		String filepath = SmartDao.class.getResource("/smart-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertSmart(String pname, int amount, Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSmart");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setInt(2, amount);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Smart> selectRecentFive(Connection conn, int selectAmount) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRecentFive");
		ResultSet rset = null;
		List<Smart> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectAmount);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Smart smart = new Smart();
				smart.setPname(rset.getString("pname"));
				smart.setAmount(rset.getInt("amount"));
				smart.setPdate(rset.getDate("pdate"));
				list.add(smart);
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

	public List<Smart> selectRankFive(Connection conn, int selectAmount) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRankFive");
		ResultSet rset = null;
		List<Smart> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectAmount);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Smart smart = new Smart();
				smart.setRank(rset.getInt("r"));
				smart.setPname(rset.getString("pname"));
				smart.setAccAmount(rset.getInt("sa"));
				list.add(smart);
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

}











