package com.kh.ajax.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.celeb.model.manager.CelebManager;
import com.kh.ajax.celeb.model.vo.Celeb;

/**
 * Servlet implementation class JsonCelebOneServlet
 */
@WebServlet("/json/celebOne.do")
public class JsonCelebOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Celeb celeb = null;
		try {
			// 1.사용자입력값
			int index = Integer.parseInt(request.getParameter("index"));
			// 2.업무로직 : 1명 조회			
			celeb = CelebManager.celebList.get(index);
			System.out.println("[JsonCelebOneServlet] celeb = " + celeb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3.응답메세지 작성
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(celeb, response.getWriter());
		
		
	}

}
