package com.kh.mvc.standard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.person.model.vo.Person;

/**
 * Servlet implementation class StandardUseBeanServlet
 */
@WebServlet("/stadard/useBean.do")
public class StandardUseBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person = new Person("홍길동", 'M', 33, false);
		request.setAttribute("person", person);
		
		request
			.getRequestDispatcher("/standard/useBean.jsp")
			.forward(request, response);
	}

}
