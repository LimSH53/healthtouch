package com.jaspa.healthtouch.center.tr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.tr_management.model.service.TrManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/center/trainer")
public class CenterTrainerController {

	private TrManagementService trManagementService;
	private MessageSource messageSource;
	
	@Autowired
	public CenterTrainerController(TrManagementService trManagementService) {
		this.trManagementService = trManagementService;
	}
	
	//트레이너 목록 조회
	@GetMapping("/list")
	public ModelAndView selectAllTrainerList(ModelAndView mv) {
		
		List<TrainerInfoDTO> trainerList = trManagementService.selectAllTrainer();
		
		log.info("trainerList : {}", trainerList);
		
		mv.addObject("trainerList", trainerList);
		mv.setViewName("center/tr_management/trainerList");
		return mv;
	}
	
	
	@GetMapping("/detail")
	public String trainerDetail(@ModelAttribute("params") TrainerInfoDTO params, @RequestParam("id") String id, Model model) {
		
		TrainerInfoDTO trainer = trManagementService.trainerDetail(id);
		
		model.addAttribute("trainer",trainer);
		
		return "center/tr_management/trainerDetail";
	}
	
	
//	@GetMapping("/delete")
//	public String deleteTrainer(@AuthenticationPrincipal UserImpl user) {
//		
//		trManagementService.deleteTrainer(user.getId());
//		//System.out.println(trId);
//		
//		return "redirect:/";
//	}
	
	@PostMapping("/delete")
	@ResponseBody
	public void deleteTrainer(@RequestParam("trId") String id) {
		trManagementService.deleteTrainer(id);
	}
	
	
	
}
