package com.kh.mvc.photo.model.dao;

import static com.kh.mvc.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.mvc.photo.model.vo.Photo;

public class PhotoDao {
	
	private Properties prop = new Properties();
	
	public PhotoDao(){
		String filepath = PhotoDao.class.getResource("/photo-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[PhotoDao] prop = " + prop);
	}

	public int selectTotalContent(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTotalContent");
		int totalContent = 0;
		
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

	public List<Photo> selectPhotoPage(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectPhotoPage");
		ResultSet rset = null;
		List<Photo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Photo photo = new Photo();
				photo.setNo(rset.getInt("no"));
				photo.setWriter(rset.getString("writer"));
				photo.setContent(rset.getString("content"));
				photo.setOriginalFilename(rset.getString("original_filename"));
				photo.setRenamedFilename(rset.getString("renamed_filename"));
				photo.setRegDate(rset.getDate("reg_date"));
				photo.setReadCount(rset.getInt("read_count"));
				list.add(photo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	
}
