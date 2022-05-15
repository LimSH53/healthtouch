package com.jaspa.healthtouch.center.locker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.locker.model.service.CenterLockerService;
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
		
		mv.addObject("lockerList", lockerList);
		mv.setViewName("center/locker/lockerList");
		return mv;
	}
}
