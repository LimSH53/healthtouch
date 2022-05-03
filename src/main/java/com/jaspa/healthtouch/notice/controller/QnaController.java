package com.jaspa.healthtouch.notice.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class QnaController {

	@GetMapping("/qna")
	public String qna() {
		
		return "notice/qna";
	}
	
	
	@GetMapping("/qnadetail")
	public String qnaDetail() {
		
		return "notice/qnadetail";
	}
	
	
	@GetMapping("/qnanone")
	public String qnaNone() {
		
		return "notice/qnanone";
	}
	
	
	@GetMapping("/qnamodify")
	public String qnaModify() {		
		
		return "notice/qnamodify";
	}
	
	@GetMapping("/qnaregist")
	public String qnaRegist() {		
		
		return "notice/qnaregist";
	}
	  

	
}