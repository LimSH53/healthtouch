package com.jaspa.healthtouch.login.controller;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/searchPwd")
	public void searchPwdForm() {}
	
	@PostMapping("/searchPwd")
	public String searchPwd(MemberDTO member, RedirectAttributes rttr) {
		// 입력한 아이디와 연락처 맞는지 확인 
		// 둘 다 해당하는 회원 있으면 result == 1
		int result = memberService.searchPwd(member);
		
		if(result > 0) {
			// 임시 비밀번호 생성 
			char[] charSet = new char[]{
					'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
					'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
			};
			
			StringBuffer sb = new StringBuffer();
			SecureRandom sr = new SecureRandom();
			sr.setSeed(new Date().getTime());
			
			int idx = 0;
			int len = charSet.length;
			// 10글자 임시 비밀번호 
			for(int i = 0; i < 10; i++) {
				idx = sr.nextInt(len);
				sb.append(charSet[idx]);
			}
			
			// 임시 비밀번호로 비밀번호 변경 
			memberService.setTempPwd(member, sb);
			System.out.println("임시 비밀번호 : " + sb);
			
			// 임시 비밀번호 전송 
			// 문자 진짜로 전송돼서 일단 주석 
			// memberService.sendTempPwd(member, sb);
			
			// 결과 
			rttr.addFlashAttribute("searchPwdResult", "success");
		} else {
			// 결과 
			rttr.addFlashAttribute("searchPwdResult", "fail");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/mypage")
	public void mypage(@AuthenticationPrincipal UserImpl user) {
		log.info("로그인 유저 : {}", user);
	}
	
	@PostMapping("/mypage")
	@ResponseBody
	public void modify(@RequestBody MemberDTO member, @AuthenticationPrincipal UserImpl user) {
		log.info("수정 정보 : {}", member);
		member.setNum(Integer.parseInt(member.getContact()) % 10000);
		memberService.modify(member);
		
		user.setName(member.getName());
		user.setContact(member.getContact());
		user.setAddress(member.getAddress());
		user.setBirthday(member.getBirthday());
		user.setGender(member.getGender());
		user.setNum(member.getNum());
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
		
		// 잠깐 주석 처리 
		// memberService.certifiedPhoneNumnber(phoneNumber, numStr);
		
		return numStr;
	}
	
	@PostMapping("/modifyPwd")
	@ResponseBody
	public int modifyPwd(@RequestBody Map<String, Object> modifyPwdMap, @AuthenticationPrincipal UserImpl user) {		
		// log.info("받은 정보 : {}", modifyPwdMap);
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(user.getId());
		requestMember.setPwd((String)modifyPwdMap.get("checkPwd"));
		
		String pwd = (String)modifyPwdMap.get("pwd");
		
		return memberService.modifyPwd(requestMember, pwd);
	}
	
	@GetMapping("/remove")
	public String removeMember(@AuthenticationPrincipal UserImpl user) {
		memberService.removeMember(user.getId());
		
		return "redirect:/";
	}
}
