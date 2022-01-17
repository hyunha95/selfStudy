package com.kh.mvc.photo.model.service;

import static com.kh.mvc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.mvc.photo.model.dao.PhotoDao;
import com.kh.mvc.photo.model.vo.Photo;

public class PhotoService {

	private PhotoDao photoDao = new PhotoDao();

	public int selectTotalContent() {
		Connection conn = getConnection();
		int totalContent = photoDao.selectTotalContent(conn);
		close(conn);
		return totalContent;
	}

	public List<Photo> selectPhotoPage(int start, int end) {
		Connection conn = getConnection();
		List<Photo> list = photoDao.selectPhotoPage(conn, start, end);
		close(conn);
		return list;
	}
}
