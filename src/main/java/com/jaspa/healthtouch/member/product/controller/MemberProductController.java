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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
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


}
