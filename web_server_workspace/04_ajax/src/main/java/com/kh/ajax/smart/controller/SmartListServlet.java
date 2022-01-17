package com.kh.ajax.smart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.smart.model.service.SmartService;
import com.kh.ajax.smart.model.vo.Smart;

/**
 * Servlet implementation class SmartListServlet
 */
@WebServlet("/smart/smartList")
public class SmartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SmartService smartService = new SmartService();

	/**
	 * insert into smartphone vales(?, ?, default)
	 * select * from (select row_number () over (order by s.pdate desc) rnum, s. * from smartphone s) where rnum <= ?
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자입력값처리
		String pname = request.getParameter("pname");
		int amount = Integer.parseInt(request.getParameter("amount"));

		System.out.println("[SmartListServlet] pname = " + pname);
		System.out.println("[SmartListServlet] amount = " + amount);
		
		// 2. 업무로직
		// 주문 등록
		int result = smartService.insertSmart(pname, amount);
		System.out.println("[SmartListServlet] result = " + result);										
		
		// 주문 조회
		final int selectAmount = 5;
		List<Smart> list = smartService.selectRecentFive(selectAmount);
		
		
		// 3. view단 처리
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
			
	
	}

}
