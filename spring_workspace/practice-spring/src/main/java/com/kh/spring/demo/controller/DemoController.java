package com.kh.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.demo.model.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	/**
	 * GET /spring/demo/devForm.do
	 */
	@RequestMapping("/demo/devForm.do")
	public String devForm() {
		log.info("/demo/devForm.do가 호출되었습니다.");
		return "demo/devForm";
	}
}
