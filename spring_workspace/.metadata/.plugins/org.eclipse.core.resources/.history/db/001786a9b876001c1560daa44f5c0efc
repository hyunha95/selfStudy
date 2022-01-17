package com.spring.board.member.controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.member.model.service.MemberService;
import com.spring.board.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login.do")
	public void login() {}
	
	@PostMapping("/enroll.do")
	public String enroll(@ModelAttribute Member member, RedirectAttributes ra) {
		log.debug("member = {}", member);

		// 비밀번호 암호화 처리
		String rawPassword = member.getPassword();
		// 랜던 salt값을 이용한 hashing처리
		String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setPassword(encodedPassword);
		
		int result = memberService.insertMember(member);
		ra.addFlashAttribute("msg", result > 0 ? "회원가입 성공" : "회원가입 실패");
		return "redirect:/";
	}
	
	@GetMapping("/enroll.do")
	public void enroll() {}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PropertyEditor editor = new CustomDateEditor(sdf, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
}


















