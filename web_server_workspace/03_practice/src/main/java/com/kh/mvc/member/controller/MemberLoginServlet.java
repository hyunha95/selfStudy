package com.kh.mvc.member.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.common.MvcUtils;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 입력값 처리
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String saveId = request.getParameter("saveId");
		
		System.out.println("memberId = " + memberId + ", password = " + password);
		
		// 3. 업무 로직 : memberId로 회원조회 & 로그인 성공여부 검사
		Member member = memberService.selectOneMember(memberId);
		System.out.println("member@MemberLogiServlet.doPost = " + member);
		System.out.println(request.getContextPath());
		
//		HttpSession session = request.getSession();
		HttpSession session = request.getSession(true);
		System.out.println(session.getId());
		
		
		// timeout설정 = web.xml설정보다 우선순위가 높다.
		session.setMaxInactiveInterval(10 * 60);
		
		// 세션 생성시간
		System.out.println(new Date(session.getCreationTime()));
		
		
		// 로그인 성공 여부
		if(member != null && password.equals(member.getPassword())) {
			// 로그인 객체를 session에 저장
			session.setAttribute("loginMember", member);
			
			// 로그인 성공
			session.setAttribute("msg", "로그인 성공!");
			
			// 아이디 저장 체크박스
			Cookie cookie = new Cookie("saveId", memberId);
			System.out.println("cookie@MemberLoginservlet : " + cookie);
			System.out.println("saveId@MemberLoginservlet : " + saveId);
			cookie.setPath(request.getContextPath());
			if(saveId != null) {
				cookie.setMaxAge(7 * 24 * 60 * 60);
				// persistent(영속)쿠키 : 초단위로 시간을 입력
				// session 쿠키 : setMaxAge설정 안한 경우
			}
			else {
				cookie.setMaxAge(0); // 즉시 삭세
			}
			response.addCookie(cookie);
			
		}
		else {
			// 로그인 실패
			session.setAttribute("msg", "로그인 실패!");
		}
		
		
		// 응답 처리 (jsp 위임 | redirect)
		// redirect 요청주소를 변경, 새로고침을 통한 오류를 방지
		// location은 브라우저가 새로 요청할 주소
		String location = request.getContextPath() + "/";
		response.sendRedirect(location);
	}

}
