package com.kh.spring.memo.controller;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

import lombok.extern.slf4j.Slf4j;

/**
 * Proxy객체를 통해 AOP를 구현한다.
 * - 인터페이스 구현객체 : jdk동적 proxy객체를 의존주입한다.
 * - 인터페이스 구현하지 않은 객체 : CGLIB에 의해 생성된 proxy객체를 의존주입한다.
 */
@Controller
@RequestMapping("/memo")
@Slf4j
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	/**
	 * 리턴하는 ViewName이 없는 경우, 요청url로 부터 jsp경로를 유추해서 찾아간다.
	 * (ViewNameTranslator빈)
	 * 
	 *  /memo/memo.do -> "memo/memo"
	 */
	@GetMapping("/memo.do")
	public void memo(Model model) {
		log.debug("컨트롤러 주업무");
		List<Memo> list = memoService.selectMemoList();
		model.addAttribute("list", list);
	}
	
	@PostMapping("/insertMemo.do")
	public String insertMemo(Memo memo, RedirectAttributes redirectAttr) {

		log.debug("의존타입 : {}", memoService.getClass());
		try {
			log.debug("memo = {}", memo);
			int result = memoService.insertMemo(memo);
			String msg = "메모 등록 성공!";
			redirectAttr.addFlashAttribute("msg", msg);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e; // spring container 예외처리 위임
		}

		return "redirect:/memo/memo.do";
	}
	
	@PostMapping("/deleteMemo.do")
	public String deleteMemo(
			@RequestParam int no, 
			@RequestParam String password, 
			RedirectAttributes redirectAttr
	) {
		int result = memoService.deleteMemo(no);
		String msg = "메모 삭제 성공!";
		redirectAttr.addFlashAttribute("msg", msg);
		return "redirect:/memo/memo.do";
	}

}










