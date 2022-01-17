package com.kh.emp.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

/**
 * interface - 구현클래스
 * 1. IStudentService - StudentService
 * 2. StudentService - StudentServiceImpl
 *
 */
public class EmpSearchController2 extends AbstractController {

	private EmpService empService;

	public EmpSearchController2(EmpService empService) {
		super();
		this.empService = empService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", request.getParameter("searchType")); // null이거나 ''일 수 있다.
		param.put("searchKeyword", request.getParameter("searchKeyword")); // null이거나 ''일 수 있다.
		param.put("gender", request.getParameter("gender"));
		param.put("salary", request.getParameter("salary")); // null이거나 ''일 수 있다.
		param.put("salaryCompare", request.getParameter("salaryCompare"));
		param.put("hireDate", request.getParameter("hireDate")); // null이거나 ''일 수 있다.
		param.put("hiredateCompare", request.getParameter("hiredateCompare"));
		System.out.println("[EmpSearchController2] param = " + param);
		// 2. 업무로직
		List<Map<String, Object>> list = empService.search2(param);
		System.out.println("[EmpSearchController2] list = " + list);
		
		// 3. jsp위임
		request.setAttribute("list", list);
		
		return "emp/search2";
	}
	
	
	
}
