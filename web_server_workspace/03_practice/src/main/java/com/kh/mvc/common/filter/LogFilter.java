package com.kh.mvc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	/**
	 * HttpServletRequest타입으로 변환이 가능
	 * HttpServletResponse타입으로 변환이 가능
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();  // /mvc/member/memberView
		String queryString = httpRequest.getQueryString();
		System.out.println("===============================================");
		System.out.println("uri@LogFilter = " + uri);
		if(queryString != null) 
			System.out.println(queryString);
		System.out.println("-----------------------------------------------");
		
		// 다음 필터 또는 Servlet연결을 위해 반드시 호출
		chain.doFilter(request, response);
		
		
		// 후처리
		System.out.println("_______________________________________________");
		System.out.println();
			
	}

}
