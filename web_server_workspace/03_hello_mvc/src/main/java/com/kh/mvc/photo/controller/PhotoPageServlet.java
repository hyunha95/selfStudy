package com.kh.mvc.photo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mvc.photo.model.service.PhotoService;
import com.kh.mvc.photo.model.vo.Photo;

/**
 * Servlet implementation class PhotoPageServlet
 */
@WebServlet("/photo/page")
public class PhotoPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotoService photoService = new PhotoService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값처리
		int cPage = Integer.valueOf(request.getParameter("cPage"));
		final int numPerPage = 5;
		// cPage 1 => 1 ~ 5
		// cPage 2 => 6 ~ 10
		// cPage 3 => 11 ~ 15...
		int start = (cPage - 1) * numPerPage + 1;
		int end = cPage * numPerPage;
		
		// 2. 업무로직
		List<Photo> list = photoService.selectPhotoPage(start, end);
		System.out.println("[PhotoPageServlet] list = " + list);
		
		// 3. json문자열을 응답메세지 출력 : gson
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
	}

}












