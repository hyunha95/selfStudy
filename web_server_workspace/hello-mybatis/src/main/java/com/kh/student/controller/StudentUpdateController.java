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
import com.kh.student.model.vo.Student;

public class StudentUpdateController extends AbstractController {

	private IStudentService studentService;

	public StudentUpdateController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력값
		int no = Integer.valueOf(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student(no, name, tel, null);
		
		// 2. 업무로직
		int result = studentService.updateStudent(student);
		
		// 3. 응답
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "사용자 정보 수정 성공!");
		new Gson().toJson(map, response.getWriter());
		return null;
	}
	
	
	
}
