package com.kh.mvc.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.common.MvcUtils;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * sql
	 * select * from member order by enroll_date desc
	 * 
	 * paging recipe
	 * 1. content section
	 * 		- cPage 현재페이지
	 * 		- numPerPage 한페이지의 게시물수 10
	 * 		- startNum, endNum
	 * 
	 * 2. pagebar section
	 * 		- totalContent 총게시물수
	 * 		- totalPage 12
	 * 		- pagebarSize
	 * 		- pageNo 증감변수
	 * 		- pageStart | pageEnd
	 * 		- url
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값
		final int numPerPage = 10;
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {}
		
		int startNum = (cPage - 1) * numPerPage + 1;
		int endNum = cPage * numPerPage;
		
		Map<String, Object> param = new HashMap<>();
		param.put("startNum", startNum);
		param.put("endNum", endNum);
		
		// 2. 업무로직
		// 2-a. content영역
		List<Member> list = memberService.selectAllMember(param);
		System.out.println("list@servlet = " + list);
		// 2-b. pagebar영역
		int totalContent = memberService.selectTotalMemberCount();
		String url = request.getRequestURI(); //mvc/admin/memberList
		System.out.println(totalContent);
		System.out.println(url);
		String pagebar = MvcUtils.getPagebar(cPage, numPerPage, totalContent, url);
		System.out.println("pagebar@servelt = " + pagebar);
		
		// 3. view단처리
		request.setAttribute("list", list);
		request.setAttribute("pagebar", pagebar);
		request
			.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp")
			.forward(request, response);
	}

}










