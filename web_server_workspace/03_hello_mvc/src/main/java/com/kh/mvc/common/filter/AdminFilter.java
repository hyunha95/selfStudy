package com.kh.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

/**
 * admin일 때만 사용할 수 있도록 설정
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember == null || !MemberService.ADMIN_ROLE.equals(loginMember.getMemberRole())) {
			session.setAttribute("msg", "관리자가 아니면 접근할 수 없습니다.");
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
	
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
