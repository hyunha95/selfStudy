package com.kh.ajax.html;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ajax.celeb.model.manager.CelebManager;

/**
 * Servlet implementation class HtmlCelebListServlet
 */
@WebServlet("/html/celebList.do")
public class HtmlCelebListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 업무로직
		request.setAttribute("celebList", CelebManager.celebList);
		
		//2. view단처리
		request
			.getRequestDispatcher("/WEB-INF/views/html/celebList.jsp")
			.forward(request, response);
	}

}
