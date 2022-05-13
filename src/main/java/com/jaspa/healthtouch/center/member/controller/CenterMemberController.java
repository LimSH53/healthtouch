package com.jaspa.healthtouch.center.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.center.member.model.service.CenterMemberService;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/center/member")
public class CenterMemberController {
	private CenterMemberService centerMemberService;
	
	@Autowired
	public CenterMemberController(CenterMemberService centerMemberService) {
		this.centerMemberService = centerMemberService;
	}
	
	@GetMapping("/memberInfo")
	public String memberInfo(Model model, @ModelAttribute("params") MemberDTO params) {
		List<MemberDTO> memberList = centerMemberService.findAllMember(params);
		
		model.addAttribute("memberList", memberList);
		
		return "center/member/memberInfo";
	}
	
	@GetMapping("/memberDetail")
	public String memberDetail(@ModelAttribute("params") MemberDTO params, @RequestParam("id") String id, Model model) {
		MemberDTO member = centerMemberService.getMemberDetail(id);
		List<OrderDTO> orderList = centerMemberService.selectOrderListById(id);
		
		model.addAttribute("member", member);
		model.addAttribute("orderList", orderList);
		
		return "center/member/memberDetail";
	}
	
	@PostMapping("/modifyMemberType")
	@ResponseBody
	public void modifyMemberType(@RequestParam("memberId") String id) {
		centerMemberService.modifyMemberType(id);
	}
	
	@PostMapping("/modifyPeriod")
	@ResponseBody
	public int modifyPeriod(@RequestBody Map<String, Object> modifyPeriodMap) {
		String categoryNo = (String) modifyPeriodMap.get("categoryNo");
		String modEndDate = (String) modifyPeriodMap.get("modEndDate");
		String memberId = (String) modifyPeriodMap.get("memberId");
		
		log.info("categoryNo : " + categoryNo + ", modEndDate : " + modEndDate + ", memberId : " + memberId);
		
		String proNo = centerMemberService.selectProductNo(categoryNo, memberId);
		
		log.info("proNo : " + proNo);
		
		return centerMemberService.modifyPeriod(proNo, modEndDate, memberId);
	}
}
