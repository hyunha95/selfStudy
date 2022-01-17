package com.kh.spring.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kh.spring.user.controller.UserController;
import com.kh.spring.user.model.service.UserService;
import com.kh.spring.user.model.service.UserServiceImpl;

@Configuration
public class UserConfig {

	@Bean
	public UserController userController() {
		return new UserController(userService());
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
}
