package com.kh.mvc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberRoleUpdateServlet
 */
@WebServlet("/admin/memberRoleUpdate")
public class AdminMemberRoleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberService();   
	
	/**
	 * update member set member_role = ? where member_id = ?
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자입력값처리
			String memberId = request.getParameter("memberId");
			String memberRole = request.getParameter("memberRole");
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberRole(memberRole);
			System.out.println("memberId@servlet = " + memberId);
			System.out.println("memberRole@servlet = " + memberRole);
			
			// 2. 업무로직
			int result = memberService.updateMemberRole(member);
			String msg = result > 0 ? "회원권한 수정 성공" : "회원권한 수정 실패";
			
			// 3. redirect
			request.getSession().setAttribute("msg", msg);
			
			String location = request.getContextPath() + "/admin/memberList";
			response.sendRedirect(location);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
