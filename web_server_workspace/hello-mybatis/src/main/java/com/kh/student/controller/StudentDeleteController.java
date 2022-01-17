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

public class StudentDeleteController extends AbstractController {

	private IStudentService studentService;

	public StudentDeleteController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 입력값
		int no = Integer.valueOf(request.getParameter("no"));
		
		// 업무요청
		int result = studentService.deleteStudent(no);
		
		// 응답
		response.setContentType("application/json; charset=utf-8");
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("msg", "학생 삭제 성공!");
		new Gson().toJson(resultMap, response.getWriter());
		return null;
	}
	
	
}
