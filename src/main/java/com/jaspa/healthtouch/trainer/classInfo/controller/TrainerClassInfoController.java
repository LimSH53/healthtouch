package com.jaspa.healthtouch.trainer.classInfo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.classInfo.model.dto.ClassDTO;
import com.jaspa.healthtouch.trainer.classInfo.model.service.TrainerClassInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer/classInfo")
public class TrainerClassInfoController {
	private TrainerClassInfoService trainerClassInfoService;
	
	@Autowired
	public TrainerClassInfoController(TrainerClassInfoService trainerClassInfoService) {
		this.trainerClassInfoService = trainerClassInfoService;
	}
	
	@GetMapping("/classList")
	public String classList(@ModelAttribute("params") ClassDTO params, Model model, @AuthenticationPrincipal UserImpl user) {
		params.setMemberId(user.getId());
		List<ClassDTO> classList = trainerClassInfoService.findAllClass(params);
		
		model.addAttribute("classList", classList);
		
		return "/trainer/classInfo/classList";
	}
	
	@PostMapping("/detail")
	@ResponseBody
	public Object getDetail(@RequestParam("classNo") int no) {
		List<ClassDTO> list = trainerClassInfoService.getDetail(no);
		
		return list;
	}
	
	@PostMapping("/regist")
	@ResponseBody
	public int registClassInfo(@RequestBody Map<String, Object> registClassInfoMap, @AuthenticationPrincipal UserImpl user) {
		String rsvNo = (String) registClassInfoMap.get("rsvNo");
		String content = (String) registClassInfoMap.get("content");
		String id = user.getId();
		
		log.info("rsvNo : " + rsvNo + ", content : " + content + ", id : " + id);
		
		return trainerClassInfoService.registClassInfo(rsvNo, content, id);
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public int modifyClassInfo(@RequestBody Map<String, Object> modifyClassInfoMap) {
		String no = (String) modifyClassInfoMap.get("classNo");
		String content = (String) modifyClassInfoMap.get("content");
		
		log.info("no : " + no + ", content : " + content);
		
		return trainerClassInfoService.modifyClassInfo(no, content);
	}
}
