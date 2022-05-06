package com.jaspa.healthtouch.notice.qna.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/notice/*")
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