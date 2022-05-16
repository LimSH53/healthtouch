package com.jaspa.healthtouch.member.product.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.login.model.service.MemberService;
import com.jaspa.healthtouch.member.product.model.dto.OrderDTO;
import com.jaspa.healthtouch.member.product.model.dto.PaymentDTO;
import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;
import com.jaspa.healthtouch.member.product.model.service.MemberProService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/product")
public class MemberProductController {

	private MemberProService memberProService;
	private MessageSource messageSource;

	@Autowired
	public MemberProductController(MemberProService memberProService, MessageSource messageSource) {
		this.memberProService = memberProService;
		this.messageSource = messageSource;
	}

	@GetMapping("membership")
	public ModelAndView selectMembershipList(ModelAndView mv) {

		List<ProductDTO> membershipList = memberProService.findAllMembership();

		log.info("membershipList : {}", membershipList);

		mv.addObject("membershipList", membershipList);
		mv.setViewName("member/product/ordMembership");

		return mv;
	}

	// 구매
	@PostMapping("payment")
	@ResponseBody
	public boolean insertPayment(@RequestBody Map<String, Object> paymentInfo, PaymentDTO payment, OrderDTO order) {
		
		log.info("paymentInfo :{}", paymentInfo);
		
		int proNo = Integer.parseInt(String.valueOf(paymentInfo.get("pro_no")));
		String memberId = String.valueOf(paymentInfo.get("userId"));
		int period = Integer.parseInt(String.valueOf(paymentInfo.get("period")));
		int remainCount = Integer.parseInt(String.valueOf(paymentInfo.get("count")));
		int price = Integer.parseInt(String.valueOf(paymentInfo.get("price")));
		String trnId = String.valueOf(paymentInfo.get("trnId"));
		if(trnId != null) {
			log.info("trnId : {}", trnId);
			order.setTrnId(trnId);
		}
			
		log.info("proNo : {}", proNo);
		log.info("memberId : {}", memberId);
		log.info("period : {}", period);
		log.info("price : {}", price);
		
		order.setProNo(proNo);
		order.setMemberId(memberId);
		
		order.setRemainCount(remainCount);
		payment.setAmount(price);
		
		log.info("order :{}", order);
		
		int result = memberProService.insertOrder(order, period);
		int result2 = memberProService.insertPayment(payment);
		
		return result > 0 ? (result2 > 0 ? true : false) : false;

	}
	
	// 구매 내역 조회
	 @GetMapping("ordList")
	 public ModelAndView selectOrderList(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
	 
	 log.info("user : {}", user);
	  
	 String userId = user.getId();
	  
	 List<PaymentDTO> orderList = memberProService.selectOrderList(userId);
	  
	 log.info("orderList : {}", orderList);
	  
	 mv.addObject("orderList", orderList);
	 mv.setViewName("member/product/ordList");
	 
	  
	  return mv; 
	  }
	
	// 구매 내역 조회
	@PostMapping("ordList")
	@ResponseBody
	public List<PaymentDTO> searchOrderList(@RequestParam(value="searchCondition", required =false, defaultValue="0") int searchCondition, @AuthenticationPrincipal UserImpl user) {
		
		log.info("user : {}", user);
		log.info("searchCondition: {}", searchCondition);
		
		String userId = user.getId();
		
		int searchOption = searchCondition;
		
		List<PaymentDTO> orderList = memberProService.searchOrderList(searchOption, userId);
		
		log.info("orderList : {}", orderList);

		return orderList;
	}	
	
	//트레이너 카테고리 조회
	@GetMapping(value="category", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<MemberDTO> findTrainerList(){
		return memberProService.findTrainerList();
	}
	
	//수강권 조회
	@GetMapping("PT")
	public ModelAndView selectPTList(ModelAndView mv) {

		List<ProductDTO> PTList = memberProService.findAllPTList();
		List<MemberDTO> trainerList = memberProService.findTrainerList();

		log.info("PTList : {}", PTList);
		log.info("trainerList : {}", trainerList);

		mv.addObject("PTList", PTList);
		mv.addObject("trainerList", trainerList);
		mv.setViewName("member/product/ordPT");

		return mv;
	}
	
	//락커 이용권
	@GetMapping("locker")
	public ModelAndView selectLockerList(ModelAndView mv) {

		List<ProductDTO> lockerList = memberProService.findAllLocker();

		log.info("membershipList : {}", lockerList);

		mv.addObject("lockerList", lockerList);
		mv.setViewName("member/product/ordLocker");

		return mv;
	}
	
	//운동복 이용권
	@GetMapping("sportswear")
	public ModelAndView selectSportswearList(ModelAndView mv) {

		List<ProductDTO> sportswearList = memberProService.findAllSportswear();

		log.info("sportswearList : {}", sportswearList);

		mv.addObject("sportswearList", sportswearList);
		mv.setViewName("member/product/ordsportswear");

		return mv;
	}	
	
	//리뷰등록을 위한 조회
	@GetMapping("review")
	public ModelAndView selectReviewInfo(ModelAndView mv, @RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {
		
		String userId = user.getId();
		
		log.info("no: {}", no);
		log.info("userId: {}", userId);
		
		OrderDTO reviewInfo = memberProService.selectReviewInfo(no, userId);
		
		log.info("reviewInfo :{}", reviewInfo);
		
		mv.addObject("reviewInfo", reviewInfo);
		mv.setViewName("member/product/reviewRegist");
		
		return mv;
	}
	
	//리뷰 등록
	@PostMapping("review")
	public String registReview(@ModelAttribute ReviewDTO review, RedirectAttributes rttr, Locale locale) {
		
		memberProService.registReview(review);
		// order 테이블 리뷰 등록여부 값 변경
		
		int orderNo = review.getOrdNo();
		memberProService.updateOrdStatus(orderNo);
		
		log.info("review:{}", review);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registReview", null, locale));
		
		return "redirect:/member/product/ordList";
	}
	
	//리뷰 조회
	@GetMapping("myreview")
	public ModelAndView selectMyreview(ModelAndView mv, @RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {
		
		String userId = user.getId();

		log.info("no: {}", no);
		log.info("userId: {}", userId);
		
		ReviewDTO myreview = memberProService.selectMyreview(no, userId);
		
		log.info("myreview :{}", myreview);
		
		mv.addObject("myreview", myreview);
		mv.setViewName("member/product/myreview");
		
		return mv;
	}
	
	
	


}
