package com.kh.web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.web.member.model.service.MemberService;
import com.kh.web.member.model.vo.Member;

/**
 * Servlet은 Controller역할을 담당한다.
 * 
 * insert into tb_member values ('honggd', '1234','홍길동', '123456-1234567', 'honggd@gmail.com', '01012341234', '개발자','독서,영화', default);
 * 
 */
@WebServlet("/member/enroll.do")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 0. 인코딩처리
			request.setCharacterEncoding("UTF-8");
			
			// 1. 요청처리 : 사용자입력값을 자바변수에 옮겨담기
			String userId = request.getParameter("userId");
			String pwd = request.getParameter("pwd");
			String userName = request.getParameter("userName");
			String ssn1 = request.getParameter("ssn1");
			String ssn2 = request.getParameter("ssn2");
			String email = request.getParameter("email");
			String tel1 = request.getParameter("tel1");
			String tel2 = request.getParameter("tel2");
			String tel3 = request.getParameter("tel3");
			String job = request.getParameter("job");
			String[] hobbies = request.getParameterValues("hobby");
			
			String tel = tel1 + tel2 + tel3;
			String ssn = ssn1 + "-" + ssn2;
			String hobby = hobbies != null ? String.join(",", hobbies) : "";
			
			
			Member member = new Member(userId, pwd, userName, ssn, email, tel, job, hobby, null);
			System.out.println("member@servlet = " + member);
			
			
			// 2. 업무로직 : db에 insert요청
			int result = memberService.insertMember(member);
			String msg = result > 0 ? "회원 등록 성공!" : "회원 등록 실패!";
			
			// 3. 응답 html 처리 : jsp에 위임
			// 사용자입력값 확인 및 등록 성공메세지 통보, 성공메시지 확인시 index페이지로 이동.
			request.setAttribute("msg", msg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/memberEnrollEnd.jsp");
			requestDispatcher.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}















