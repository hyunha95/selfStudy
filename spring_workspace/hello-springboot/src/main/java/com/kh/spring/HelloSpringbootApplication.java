package com.kh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Configuration 
 *  - 빈 등록 설정클래스 @Bean 빈등록
 * 
 * @EnabledAutoConfiguration
 *  - application-context구성
 * 
 * @ComponentScan
 *  - context:component-scan태그와 동일. basePackage이하 어노테이션처리
 */
@SpringBootApplication
public class HelloSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringbootApplication.class, args);
	}

}
