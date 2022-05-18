package com.jaspa.healthtouch.center.revenue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.revenue.model.service.RevenueService;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/revenue")
public class RevenueController {
	
	private RevenueService revenueService;
	
	@Autowired
	public RevenueController(RevenueService revenueService) {
		this.revenueService = revenueService;
	}
	
	@GetMapping("/all")
	public ModelAndView selectAllrevenue(ModelAndView mv, @ModelAttribute("params") PaymentDTO params) {
		
		List<PaymentDTO> revenueList = revenueService.selectAllrevenue(params);
		
		log.info("revenueList :{}", revenueList);
		
		mv.addObject("revenueList", revenueList);
		mv.setViewName("center/revenue/allRevenue");
		
		return mv;
	}

}
