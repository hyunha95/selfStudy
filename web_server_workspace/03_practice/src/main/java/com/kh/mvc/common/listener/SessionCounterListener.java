package com.kh.mvc.common.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener{

	private static int count;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("접속사용자수(+) : " + count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if(count > 0)
			count--;
		System.out.println("접속사용자수(-) : " + count);
	}
	
	
}
