package com.jaspa.healthtouch.notice.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;
import com.jaspa.healthtouch.notice.trainer.model.service.TrainerProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class TrainerProfileController {
	private TrainerProfileService trainerProfileService;
	
	
	@Autowired
	public TrainerProfileController(TrainerProfileService trainerProfileService) {
		this.trainerProfileService = trainerProfileService;
	}
	
	//트레이너 소개 조회
	@GetMapping("/trainerintro")
	public String trainerIntro() {		
		
		return "notice/trainerintro";
	}
	
	//트레이너 후기 조회(서현승)
	@GetMapping("/trainerprofile")
	public ModelAndView trainerProfile(ModelAndView mv,@RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {		

		String memberId = user.getId();
		ReviewDTO trainerProfile = trainerProfileService.trainerProfile(no, memberId);
		
		log.info("no: {}", no);
		log.info("memberId: {}", memberId);
		mv.addObject("trainerProfile",trainerProfile);
		mv.setViewName("notice/trainerprofile");
		
		return mv;
	}
	
	//트레이너 후기 조회(남지현)
	@GetMapping("/trainerprofile1")
	public ModelAndView trainerProfile1(ModelAndView mv,@RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {		

		String memberId = user.getId();
		ReviewDTO trainerProfile1 = trainerProfileService.trainerProfile1(no, memberId);
	
		mv.addObject("trainerProfile1",trainerProfile1);
		mv.setViewName("notice/trainerprofile1");
		
		return mv;
	}
	
	//트레이너 후기 조회(허승준)
	@GetMapping("/trainerprofile2")
	public ModelAndView trainerProfile2(ModelAndView mv,@RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {		

		String memberId = user.getId();
		ReviewDTO trainerProfile2 = trainerProfileService.trainerProfile2(no, memberId);
	
		mv.addObject("trainerProfile2",trainerProfile2);
		mv.setViewName("notice/trainerprofile2");
		
		return mv;
	}
	
	//트레이너 후기 조회(한주은)
	@GetMapping("/trainerprofile3")
	public ModelAndView trainerProfile3(ModelAndView mv,@RequestParam("ordNo") int no, @AuthenticationPrincipal UserImpl user) {		

		String memberId = user.getId();
		ReviewDTO trainerProfile3 = trainerProfileService.trainerProfile3(no, memberId);
	
		mv.addObject("trainerProfile3",trainerProfile3);
		mv.setViewName("notice/trainerprofile3");
		
		return mv;
	}

}