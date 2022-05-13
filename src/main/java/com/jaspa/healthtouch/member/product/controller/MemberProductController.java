package com.jaspa.healthtouch.member.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.login.model.service.MemberService;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;
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

	@PostMapping("payment")
	@ResponseBody
	public boolean insertPayment(@RequestBody Map<String, Object> paymentInfo, PaymentDTO payment, OrderDTO order) {
		
		log.info("paymentInfo :{}", paymentInfo);
		
		int proNo = Integer.parseInt(String.valueOf(paymentInfo.get("pro_no")));
		String memberId = String.valueOf(paymentInfo.get("userId"));
		int period = Integer.parseInt(String.valueOf(paymentInfo.get("period")));
		int price = Integer.parseInt(String.valueOf(paymentInfo.get("price")));
		
		log.info("proNo : {}", proNo);
		log.info("memberId : {}", memberId);
		log.info("period : {}", period);
		log.info("price : {}", price);
		
		order.setProNo(proNo);
		order.setMemberId(memberId);
		payment.setAmount(price);
		
		log.info("order :{}", order);
		
		int result = memberProService.insertOrder(order, period);
		int result2 = memberProService.insertPayment(payment);
		
		return result > 0 ? (result2 > 0 ? true : false) : false;

	}
	
	// 구매 내역 조회
	/*
	 * @GetMapping("ordList") public ModelAndView
	 * selectOrderList(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
	 * 
	 * log.info("user : {}", user);
	 * 
	 * String userId = user.getId();
	 * 
	 * List<PaymentDTO> orderList = memberProService.selectOrderList(userId);
	 * 
	 * log.info("orderList : {}", orderList);
	 * 
	 * mv.addObject("orderList", orderList);
	 * mv.setViewName("member/product/ordList");
	 * 
	 * 
	 * return mv; }
	 */
	
	// 구매 내역 조회
	@GetMapping("ordList")
	@ResponseBody
	public ModelAndView searchOrderList(@RequestParam(value="searchCondition", required =false, defaultValue="0") int searchCondition, @AuthenticationPrincipal UserImpl user, ModelAndView mv) {
		
		log.info("user : {}", user);
		log.info("searchCondition: {}", searchCondition);
		
		String userId = user.getId();
		
		int searchOption = searchCondition;
		
		List<PaymentDTO> orderList = memberProService.searchOrderList(searchOption, userId);
		
		log.info("orderList : {}", orderList);
		
		mv.addObject("orderList", orderList);
		mv.setViewName("member/product/ordList");
		
		
		return mv;
	}
	
	
	
	


}
