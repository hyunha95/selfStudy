package com.kh.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;

public class StudentTotalCountController extends AbstractController {

	private IStudentService studentService;

	public StudentTotalCountController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 업무로직
		int totalCount = studentService.selectStudentTotalCount();
		System.out.println("[StudentTotalCountController] totalCount = " + totalCount);
		
		// 2. 응답메세지 출력 : json문자열
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		new Gson().toJson(map, response.getWriter());
		
		return null; // DispatcherServlet의 이후처리 없음.
	}
	
	
}
