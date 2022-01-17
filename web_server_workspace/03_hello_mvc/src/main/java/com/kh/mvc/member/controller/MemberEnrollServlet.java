package com.kh.mvc.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.common.MvcUtils;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/member/memberEnroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * GET /mvc/member/memberEnroll
	 * 
	 * - 회원가입폼을 제공
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request
			.getRequestDispatcher("/WEB-INF/views/member/memberEnroll.jsp")
			.forward(request, response);
	}

	/**
	 * POST /mvc/member/memberEnroll
	 * 
	 * - DB에 레코드 기록
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1.인코딩처리 utf-8
			request.setCharacterEncoding("utf-8");
			
			// 2.사용자입력값 처리 사용자입력값 -> Member VO객체 생성
			String memberId = request.getParameter("memberId");
			String password = request.getParameter("password");
			String memberName = request.getParameter("memberName");
			String _birthday = request.getParameter("birthday"); 
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String[] _hobby = request.getParameterValues("hobby");
			
			System.out.println("email = " + email);
			System.out.println("_birthday = " + _birthday);
			System.out.println("_hobby = " + _hobby);
			
			
			// birthday : String -> java.sql.Date
			Date birthday = "".equals(_birthday) ?  null : Date.valueOf(_birthday);
			System.out.println(birthday);
			
			// hobbies : String[] -> String
			String hobby = (_hobby != null) ? String.join(",", _hobby) : "";
			
			Member member = new Member(memberId, password, memberName, MemberService.USER_ROLE, gender, birthday, email, phone, address, hobby, null);
			System.out.println("member@servlet = " + member);
			
			// 3.업무로직 service객체의 insertMember호출 & 생성한 member객체 전달
			int result = memberService.insertMember(member);
			String msg = result > 0 ? "회원가입성공!" : "회원가입실패!";
			
			// 4.redirect 및 msg처리
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			String location = request.getContextPath() + "/";
			response.sendRedirect(location);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // tomcat이 error.jsp로 위임하도록 처리
		}
	}

}








