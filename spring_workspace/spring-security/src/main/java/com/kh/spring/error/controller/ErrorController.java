package com.kh.spring.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("/accessDenied.do")
	@ResponseBody
	public String accessDenied() {
		return "권한이 없으시네요. 돌아가세요.~";
	}
}
