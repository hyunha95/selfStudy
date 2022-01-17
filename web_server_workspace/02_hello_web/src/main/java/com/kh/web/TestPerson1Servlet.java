package com.kh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet클래스는 웹서비스를 위한 자바클래스
 *	- HttpServlet을 상속
 *	- 전송방식에 따른 메소드 오버라이딩 doGet
 *	- web.xml에 servlet 등록
 *
 */
public class TestPerson1Servlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		// 요청 정보 확인
		// HttpServletRequest 사용자 요청 객체
		// 1. 사용자입력값
		String name = request.getParameter("name"); // html input태그의 name 속성
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food"); //복수개
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("food = " + (foods != null ? Arrays.toString(foods) : "null"));
		
		
		
		// 응답 html 작성
		// HttpServletResponse 사용자 응답 객체
		// 메세지헤더 - html선언
		response.setContentType("text/html; charset=utf-8");
		
		// 메세지바디
		PrintWriter out = response.getWriter(); // 대상을 http 응답 message로 하는 문자기반 출력스트림
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>개인취향검사결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인취향검사결과 - GET</h1>");
		out.printf("<p>이름 : %s</p>%n", name);
		out.printf("<p>선호 색상 : %s</p>%n", color);
		out.printf("<p>선호 동물 : %s</p>%n", animal);
		out.printf("<p>선호 음식 : %s</p>%n", (foods != null ? Arrays.toString(foods) : "없음"));
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
