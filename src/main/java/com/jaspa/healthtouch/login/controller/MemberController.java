package com.jaspa.healthtouch.login.controller;

import java.util.Locale;
import java.util.Random;

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
	
	@GetMapping("/searchId")
	public void searchIdForm() {}
	
	@PostMapping("/searchId")
	public String searchId(MemberDTO member, RedirectAttributes rttr) {
		String result = memberService.searchId(member);
		
		rttr.addFlashAttribute("searchIdResult", result);
		log.info("result : {}", result);
		
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
	
	@PostMapping("/isExistContact")
	@ResponseBody
	public int isExistContact(@RequestParam("phoneNumber") String phoneNumber) {
		return memberService.isExistContact(phoneNumber);
	}
	
	@GetMapping("/checkContact")
	public @ResponseBody String sendSMS(String phoneNumber) {
		Random rand = new Random();
		String numStr = "";
		for(int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		log.info("수신자 번호 : {}", phoneNumber);
		log.info("인증번호 : {}", numStr);
		
		memberService.certifiedPhoneNumnber(phoneNumber, numStr);
		
		return numStr;
	}
}
