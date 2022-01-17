package com.kh.spring.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * 로그인 성공 후 바로 호출될 메소드
	 * - 리다이렉트 직접 처리할 것
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.debug("로그인 성공했습니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		log.debug("authentication = {}", authentication);
		
		String location = request.getContextPath() + "/";
		response.sendRedirect(location);

	}

}
