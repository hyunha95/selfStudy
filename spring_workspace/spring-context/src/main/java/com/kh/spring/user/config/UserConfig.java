package com.kh.spring.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kh.spring.user.controller.UserController;
import com.kh.spring.user.model.service.UserService;
import com.kh.spring.user.model.service.UserServiceImpl;

/**
 * 빈등록 설정클래스
 * 자식 @Bean 어노테이션처리가 가능
 */
@Configuration
public class UserConfig {
	
	@Bean
	public UserController userController() {
		return new UserController(userService());
	}
	
	/**
	 * @Bean : 리턴객체를 빈으로 등록
	 * - id : 메소드명
	 * - class : 리턴타입
	 */
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
}
