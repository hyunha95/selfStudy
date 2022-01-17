package com.kh.emp.model.service;

import com.kh.emp.model.dao.EmpDao;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao;

	public EmpServiceImpl(EmpDao empDao) {
		super();
		this.empDao = empDao;
	}
	
}
