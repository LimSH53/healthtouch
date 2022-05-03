package com.jaspa.healthtouch.notice.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@GetMapping("/notice")
	public String notice() {
		
		return "notice/notice";
	}
	
	
	@GetMapping("/noticedetail")
	public String noticeDetail() {
		
		return "notice/noticedetail";
	}
		
	
	
	@GetMapping("/noticenone")
	public String noticeNone() {
		
		return "notice/noticenone";
	}
	
	
	@GetMapping("/noticemodify")
	public String noticeModify() {
		
		return "notice/noticemodify";
	}
	
	@GetMapping("/noticeregist")
	public String noticeRegist() {
		
		return "notice/noticeregist";
	}
	
	
	@GetMapping("/trainerintro")
	public String trainerIntro() {		
		
		return "notice/trainerintro";
	}
	
	@GetMapping("/trainerprofile")
	public String trainerProfile() {		
		
		return "notice/trainerprofile";
	}
	
	
	
	@GetMapping("/trainerprofile1")
	public String trainerProfile1() {		
		
		return "notice/trainerprofile1";
	}
	
	
	@GetMapping("/trainerprofile2")
	public String trainerProfile2() {		
		
		return "notice/trainerprofile2";
	}
	
	@GetMapping("/trainerprofile3")
	public String trainerProfile3() {		
		
		return "notice/trainerprofile3";
	}
	
}