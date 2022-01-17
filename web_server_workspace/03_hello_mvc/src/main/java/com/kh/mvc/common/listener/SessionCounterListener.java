package com.kh.mvc.common.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener
 * 		- HttpSession 객체가 생성되거나 소멸될 때 발생
 *
 */
public class SessionCounterListener implements HttpSessionListener {

	private static int count;
	
	// sessionCreated : 세션이 생성되었을 경우 실행되는 메소드
	@Override
    public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("접속사용자수(+) : " + count);
	}

	// sessionDestroyed : 세션이 무효화 되었을 경우 실행되는 메소드
	@Override
    public void sessionDestroyed(HttpSessionEvent se) {
		if(count > 0)
			count--;
		System.out.println("접속사용자수(-) : " + count);
	}
	
	
}
