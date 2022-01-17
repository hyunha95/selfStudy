package com.kh.mvc.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.mvc.common.MvcUtils;

/**
 * 
 * HttpServletRequest 인터페이스
 * HttpServletRequestWrapper 자식클래스
 * EncryptWrapper
 *
 */
public class EncryptWrapper extends HttpServletRequestWrapper {

	/**
	 * HttpServletRequestWrapper에 기본생성자가 존재하지 않으므로
	 * 명시적으로 파라미터생성자 호출해야 한다.
	 * @param request
	 */
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		switch(name) {
		case "password": 
		case "oldPassword": 
		case "newPassword": 
			return MvcUtils.getEncryptedPassword(super.getParameter(name));
		default : 
			return super.getParameter(name);
		}
	}
	
	
	
	
}
