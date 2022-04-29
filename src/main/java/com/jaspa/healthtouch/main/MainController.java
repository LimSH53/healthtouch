package com.jaspa.healthtouch.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	// 메인 따로 없이 로그인 페이지가 메인 
	@GetMapping(value="/")
	public String main() {
		return "/member/login";
	}
	
	@PostMapping(value="/")
	public String redirectMain() {
		return "redirect:/member/login";
	}
}
