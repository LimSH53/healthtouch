package com.jaspa.healthtouch.center.locker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.locker.model.service.CenterLockerService;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/center/locker")
public class CenterLockerController {

	private CenterLockerService centerLockerService;
	
	@Autowired
	public CenterLockerController(CenterLockerService centerLockerService) {
		this.centerLockerService = centerLockerService;
	}
	
	//락커 조회
	@GetMapping("/list")
	public ModelAndView selectAllLockerList(ModelAndView mv) {
		
		List<LockerDTO> lockerList = centerLockerService.selectAllLocker();
		log.info("lockerList : {}", lockerList);
		mv.addObject("lockerList", lockerList);
		mv.setViewName("center/locker/lockerList");
		return mv;
	}
	
	/* 락커 등록 */
	@PostMapping("/regist")
	@ResponseBody
	public void registLocker(LockerDTO locker) {
		centerLockerService.registLocker(locker);
		
	}
	
	
	//락커 등록 시 이름 검색어 자동완성	
	@RequestMapping(value = "/auto")
	public @ResponseBody Map<String, Object> autoComplete(@RequestParam Map<String, Object> paramMap) throws Exception{
		
		List<Map> resultList = centerLockerService.autoComplete(paramMap);
		paramMap.put("resultList", resultList);

		return paramMap;
	}
	
	
}

	