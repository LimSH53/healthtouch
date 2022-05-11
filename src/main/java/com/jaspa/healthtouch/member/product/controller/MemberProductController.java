package com.jaspa.healthtouch.member.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.member.product.model.service.MemberProService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/product")
public class MemberProductController {
	
	private MemberProService memberProService;
	
	@Autowired
	public MemberProductController(MemberProService memberProService) {
		this.memberProService = memberProService;
	}
	
	@GetMapping("membership")
	public ModelAndView selectMembershipList(ModelAndView mv) {
		
		List<ProductDTO> membershipList = memberProService.findAllMembership();
		
		log.info("membershipList : {}", membershipList);
		
		mv.addObject("membershipList", membershipList);
		mv.setViewName("member/product/ordMembership");
		
		return mv;
	}
	
	/*
	 * @PostMapping("payment") public String registPayment()
	 */
	
}
