package com.kh.ajax.xml;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ajax.celeb.model.manager.CelebManager;
import com.kh.ajax.celeb.model.vo.Celeb;

/**
 * Servlet implementation class XmlCelebListServlet
 */
@WebServlet("/xml/celebList.do")
public class XmlCelebListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업무로직
		List<Celeb> celebList = CelebManager.celebList;
		
		// 2. view단 처리 : jsp를 통해서 동적으로 xml문서를 생성
		request.setAttribute("celebList", celebList);
		request
			.getRequestDispatcher("/WEB-INF/views/xml/celebList.jsp")
			.forward(request, response);
		
		
	}

}
