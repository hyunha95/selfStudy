package com.kh.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {

	/**
	 * 리턴할 String은 jsp 또는 redirect에 관한 경로이다.
	 * 자식 Controller클래스에서 override해야 하고, override없이 호출하면 예외를 던진다.
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		throw new MethodNotAllowedException("GET");
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		throw new MethodNotAllowedException("POST");
	}
}
