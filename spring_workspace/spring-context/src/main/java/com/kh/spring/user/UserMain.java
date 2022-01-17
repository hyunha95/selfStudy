package com.kh.spring.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kh.spring.user.config.UserConfig;
import com.kh.spring.user.controller.UserController;

public class UserMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		System.out.println("----------------- Spring Container 초기화 완료 ---------------------");
		
		UserController controller = context.getBean(UserController.class);
		controller.selectOneUser(8);
	}

}
