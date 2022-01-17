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
 *	- 전송방식에 따른 메소드 오버라이딩 doPost
 *	- web.xml에 servlet 등록
 *
 */
public class TestPerson2Servlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// 수정되었을 때 메소드 바디에 한해서 서버를 다시 껐다 키지 않아도됨
		
		// 1. 요청 처리
		// POST 요청 일때 message body에 내용에 대한 인코딩 선언
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("food = " + (foods != null ? Arrays.toString(foods) : "null"));
		
		// 2. 업무로직 : 추천
		String todayRecommend = "";
		String style = "";
		switch(color) {
		case "빨강" : todayRecommend = "빨간 떡볶이"; style="red"; break;
		case "노랑" : todayRecommend = "노란 카레"; style="yellow"; break;
		case "초록" : todayRecommend = "초록 젤리"; style="green"; break;
		case "파랑" : todayRecommend = "파란 캔디바"; style="blue"; break;
		}
		
		// 3. 응답 작성
		// 메세지헤더 - html선언
		response.setContentType("text/html; charset=utf-8");
				
		// 메세지바디
		PrintWriter out = response.getWriter(); // 대상을 http 응답 message로 하는 문자기반 출력스트림
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>개인취향검사결과</title>");
		out.printf("<style>#todayRecommend { color: %s; }</style>%n", style);
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인취향검사결과 - POST</h1>");
		out.printf("<p>이름 : %s</p>%n", name);
		out.printf("<p>선호 색상 : %s</p>%n", color);
		out.printf("<p>선호 동물 : %s</p>%n", animal);
		out.printf("<p>선호 음식 : %s</p>%n", (foods != null ? Arrays.toString(foods) : "없음"));
		out.println("<hr/>");
		out.printf("<h2>그럼 오늘 <span id='todayRecommend'>%s</span>어떠세요?</h2>%n", todayRecommend);
		out.println("</body>");
		out.println("</html>");
	}
}
