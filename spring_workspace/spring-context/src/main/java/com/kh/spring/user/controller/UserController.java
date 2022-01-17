package com.kh.spring.user.controller;

import com.kh.spring.user.model.service.UserService;

public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public void selectOneUser(int no) {
		userService.selectOneUser(no);
	}
	
}
