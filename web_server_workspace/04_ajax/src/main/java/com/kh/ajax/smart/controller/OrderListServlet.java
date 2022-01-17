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
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/smart/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SmartService smartService = new SmartService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 주문 조회
		final int selectAmount = 5;
		List<Smart> list = smartService.selectRecentFive(selectAmount);
		
		
		// 3. view단 처리
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
	}

}
