package com.jaspa.healthtouch.member.locker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.locker.model.dto.LockerDTO;
import com.jaspa.healthtouch.member.locker.model.service.LockerMemberService;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller	
@RequestMapping("/member/product")
public class LockerMemberController {

	
	private LockerMemberService lockerMemberService;


	@Autowired
	public LockerMemberController(LockerMemberService lockerMemberService) {
		this.lockerMemberService = lockerMemberService;
	}
	/* @AuthenticationPrincipal UserImpl user */
	
	@GetMapping("/lockerAll")
	public ModelAndView selectAllLocker(ModelAndView mv) {
		
		List<LockerDTO> lockerList = lockerMemberService.selectAllLocker();		
		log.info("lockerList : {}", lockerList);		
		mv.addObject("lockerList", lockerList);
		mv.setViewName("member/product/locker-site");

		
		return mv;
	}
	
	

	/* 락커 등록 */
	@PostMapping("/regist")
	@ResponseBody
	public void registLocker(LockerDTO locker) {
		lockerMemberService.registLocker(locker);
		lockerMemberService.insertCenterLockerOrder(locker);
	}

	
}
