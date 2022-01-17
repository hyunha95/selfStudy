package com.kh.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MenuOrder.do")
public class MenuOrder extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// 0. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 1. 요청 처리
		String mainMenu = request.getParameter("mainMenu");
		String sideMenu = request.getParameter("sideMenu");
		String drinkMenu = request.getParameter("drinkMenu");
		
		// 2. 업무로직
		int price = 0;
		switch(mainMenu) {
		case "한우버거" : price += 5000; break;
		case "밥버거" : price += 4500; break;
		case "치즈버거" : price += 4000; break;
		}
		switch(sideMenu) {
		case "감자튀김" : price += 1500; break;
		case "어니언링" : price += 1700; break;
		}
		switch(drinkMenu) {
		case "콜라" : price += 1000; break;
		case "사이다" : price += 1000; break;
		case "커피" : price += 1500; break;
		case "밀크쉐이크" : price += 2500; break;
		}
		
		
		// 3. 요청처리
		request.setAttribute("price", price);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/menuEnd.jsp");
		requestDispatcher.forward(request, response);
		
	}
}
