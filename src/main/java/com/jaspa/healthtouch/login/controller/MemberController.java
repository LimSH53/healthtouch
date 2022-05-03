package com.jaspa.healthtouch.login.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.login.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	private MemberService memberService;
	private MessageSource messageSource;
	
	@Autowired
	public MemberController(MemberService memberService, MessageSource messageSource) {
		this.memberService = memberService;
		this.messageSource = messageSource;
	}
	
	@GetMapping("/login")
	public void loginForm() {}
	
	@PostMapping("/login")
	public void loginForm(@RequestParam(required=false) String errorMessage, Model model) {
		model.addAttribute("errorMessage", errorMessage);
	}
	
	@GetMapping("/regist")
	public void registForm() {}
	
	@PostMapping("/regist")
	public String regist(MemberDTO member, RedirectAttributes rttr, Locale locale) {
		memberService.regist(member);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMember", null, locale));
		
		return "redirect:/";
	}
	
	@GetMapping("/mypage")
	public void mypage(@AuthenticationPrincipal UserImpl user) {
		log.info("로그인 유저 : {}", user);
	}
	
	@PostMapping("/checkId")
	@ResponseBody
	public int checkId(@RequestParam("memberId") String memberId) {
		return memberService.checkId(memberId);
	}
}
