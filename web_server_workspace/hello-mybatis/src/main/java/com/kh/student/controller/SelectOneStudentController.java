package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class SelectOneStudentController extends AbstractController {

	private IStudentService studentService;

	public SelectOneStudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값
		int no = Integer.valueOf(request.getParameter("no"));
		System.out.println("[SelectOneStudentController] no = " + no);
		
		// 2. 업무로직
		Student student = studentService.selectOneStudent(no);
		System.out.println("[SelectOneStudentController] student = " + student);
		
		// 3. 응답메세지 : json
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(student, response.getWriter());
		
		return null;
	}
	
	
}
