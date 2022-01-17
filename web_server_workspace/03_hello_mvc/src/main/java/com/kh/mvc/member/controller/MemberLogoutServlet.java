package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutServlet
 */
@WebServlet("/member/logout")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//현재 사용중인 세션을 만료시킨다.
		// create:boolean - false : session이 존재하면 해당 session객체를, 아니면 null을 리턴.
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		
		// redirect - url변경
		String location = request.getContextPath() + "/";
		response.sendRedirect(location);
		
		
	}

}
