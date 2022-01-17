package com.kh.mvc.el;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.person.model.vo.Person;

/**
 * Servlet implementation class ElBasicsServlet
 */
@WebServlet("/el/basics.do")
public class ElBasicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jsp에서 사용할 데이터
		// request
		request.setAttribute("coffee", "예가체프");
		request.setAttribute("num", 12345);
		request.setAttribute("person", new Person("세종대왕", 'M', 76, true));
		request.setAttribute("movie", "스파이더맨");
		
		List<String> items = Arrays.asList("탁상시계", "머그잔", "USB", "마이크");
		request.setAttribute("items", items);
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "아브라함");
		map.put("today", new Date());
		map.put("Dr.Zang", new Person("장영실", 'M', 55, true));
		request.setAttribute("map", map);
		
		// session
		HttpSession session = request.getSession();
		session.setAttribute("book", "죽음의 수용소에서");
		
		// application
		ServletContext application = getServletContext();
		application.setAttribute("movie", "듄");
		
		request
			.getRequestDispatcher("/el/basics.jsp")
			.forward(request, response);
		
	}

}







