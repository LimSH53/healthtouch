package com.jaspa.healthtouch.member.classInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;
import com.jaspa.healthtouch.member.classInfo.model.service.MemberClassInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/classInfo")
public class MemberClassInfoController {
	private MemberClassInfoService memberClassInfoService;
	
	@Autowired
	public MemberClassInfoController(MemberClassInfoService memberClassInfoService) {
		this.memberClassInfoService = memberClassInfoService;
	}
	
	@GetMapping("/classList")
	public String classList(@ModelAttribute("params") ClassDTO params, Model model, @AuthenticationPrincipal UserImpl user) {
		params.setMemberId(user.getId());
		List<ClassDTO> classList = memberClassInfoService.findAllClass(params);
		
		model.addAttribute("classList", classList);
		
		return "member/classInfo/classList";
	}
	
	@PostMapping("/detail")
	@ResponseBody
	public Object getDetail(@RequestParam("classNo") int no) {
		List<ClassDTO> list = memberClassInfoService.getDetail(no);
		
		return list;
	}
}
