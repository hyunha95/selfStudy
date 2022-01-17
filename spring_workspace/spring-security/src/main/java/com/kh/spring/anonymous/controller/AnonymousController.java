package com.kh.spring.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AnonymousController {

	@GetMapping("/anonymous/anonymous.do")
	public void anonymous() {}
}
