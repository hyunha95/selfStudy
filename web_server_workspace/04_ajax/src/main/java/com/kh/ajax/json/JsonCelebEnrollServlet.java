package com.kh.ajax.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.celeb.model.manager.CelebManager;
import com.kh.ajax.celeb.model.vo.Celeb;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class JsonCelebEnrollServlet
 */
@WebServlet("/json/celebEnroll.do")
public class JsonCelebEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. MultipartRequest객체 : 서버컴퓨터에 사용자 업로드파일 저장
		String saveDirectory = getServletContext().getRealPath("/images");
		int maxPostSize = 1024 * 1024 * 10; // 10mb
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = 
				new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		
		// 1. 사용자입력값처리
		String name = multipartRequest.getParameter("name");
		String phone = multipartRequest.getParameter("phone");
		int age = Integer.parseInt(multipartRequest.getParameter("age"));
		boolean married = multipartRequest.getParameter("married") != null;
		String profile = multipartRequest.getFilesystemName("profile");
		Celeb newCeleb = new Celeb(name, phone, age, profile, married);
		System.out.println("[JsonCelebEnrollServlet] newCeleb = " + newCeleb);
		
		// 2. 업무로직 : CelebManager.celebList에 추가
		CelebManager.celebList.add(newCeleb);
		
		// 3. 응답메세지 작성
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "Celeb등록 성공!");
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(map, response.getWriter());
		
	}

}
