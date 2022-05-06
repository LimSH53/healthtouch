package com.jaspa.healthtouch.center.tr_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.tr_management.model.service.TrManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/center/trainer")
public class CenterTrainerController {

	private TrManagementService trManagementService;
	
	@Autowired
	public CenterTrainerController(TrManagementService trManagementService) {
		this.trManagementService = trManagementService;
	}
	
	@GetMapping("/list")
	
	public ModelAndView selectAllTrainerList(ModelAndView mv) {
		
		List<TrainerInfoDTO> trainerList = trManagementService.selectAllTrainer();
		
		log.info("trainerList : {}", trainerList);
		
//		List<TrainerInfoDTO> trainerList = new ArrayList<>();
//		trainerList.add(new TrainerInfoDTO());
		
		mv.addObject("trainerList", trainerList);
		mv.setViewName("center/tr_management/trainerList");
		
		
		
		
		return mv;
	}
	
	
}
