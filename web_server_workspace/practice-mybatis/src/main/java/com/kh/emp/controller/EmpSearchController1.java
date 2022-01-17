package com.kh.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

public class EmpSearchController1 extends AbstractController {

	private EmpService empService;

	public EmpSearchController1(EmpService empService) {
		super();
		this.empService = empService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "emp/search1";
	}
	
	
	
	
}
