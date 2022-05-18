package com.jaspa.healthtouch.notice.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
	public ModelAndView trainerprofile(ModelAndView mv) {		
		ReviewDTO trainerPr = trainerProfileService.trainerprofile();
	
		mv.addObject("trainerPr",trainerPr);
		mv.setViewName("notice/trainerprofile");
		log.info("trainerPr:{}",trainerPr);
		
		return mv;
	}
	


}