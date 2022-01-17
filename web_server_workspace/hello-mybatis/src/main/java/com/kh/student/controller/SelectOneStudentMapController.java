package com.kh.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;

public class SelectOneStudentMapController extends AbstractController {
	
	private IStudentService studentService;

	public SelectOneStudentMapController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값 처리
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("[SelectOneStudentMapController] no = " + no);
		
		// 2. 업무로직 : no 조회
		Map<String, Object> studentMap = studentService.selectOneStudentMap(no);
		System.out.println("[SelectOneStudentMapController] studentMap = " + studentMap);
		
		//3 . 응답메세지 처리
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		gson.toJson(studentMap, response.getWriter());
		
		return null;
	}

	
}
