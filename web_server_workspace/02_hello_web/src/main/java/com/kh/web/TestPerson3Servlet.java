package com.kh.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson3Servlet
 */
@WebServlet("/testPerson3.do")
public class TestPerson3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 인코딩처리
		request.setCharacterEncoding("UTF-8");
		
		// 1. 요청처리 : 사용자입력값 -> 자바변수
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("food = " + (foods != null ? Arrays.toString(foods) : "null"));
		
		// 2. 업무로직 : db조회 + 1000가지 연산
		String todayRecommend = "";
		String style = "";
		switch(color) {
		case "빨강" : todayRecommend = "빨간 떡볶이"; style="red"; break;
		case "노랑" : todayRecommend = "노란 카레"; style="yellow"; break;
		case "초록" : todayRecommend = "초록 젤리"; style="green"; break;
		case "파랑" : todayRecommend = "파란 캔디바"; style="blue"; break;
		}
		
		// 3. 응답처리 : jsp 위임(RequestDispatcher객체의 forward)
		// jsp에서 사용할 데이터를 속성으로 저장
		request.setAttribute("todayRecommend", todayRecommend);
		request.setAttribute("style", style);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/testPersonResult.jsp"); // 여기서 /는 src/main/webapp을 가리킨다.
		requestDispatcher.forward(request, response);
		// forward이후에는 코드작성하면 안됨.
	}

}
