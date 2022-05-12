package com.jaspa.healthtouch.trainer.trainerInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;
import com.jaspa.healthtouch.trainer.trainerInfo.model.service.TrainerService;
import com.jaspa.healthtouch.trainer.trainerInfo.model.service.TrainerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer")
public class TrainerInfoController {
	private TrainerService trainerService;
	
	

	@Autowired
	public TrainerInfoController(TrainerService trainerService) {
		this.trainerService = trainerService;
	}
	
	@GetMapping("/trainer-info")
	public void selectTrainerInfo(Model model, @AuthenticationPrincipal UserImpl user) {
		
		TrainerMemberDTO trainerInfo = trainerService.selectTrainer(user.getId());
		model.addAttribute("trainerInfo", trainerInfo);
		
		log.info(trainerInfo.toString());
	}
	
	
	@PostMapping("/trainer-info")
	public void selectTrainerInfo(TrainerMemberDTO trainer,  @AuthenticationPrincipal UserImpl user, Model model) {
		
		trainer.setId(user.getId());
		log.info(trainer.toString());
		trainerService.updateTrainer(trainer);
		
		TrainerMemberDTO trainerInfo = trainerService.selectTrainer(user.getId());
		model.addAttribute("trainerInfo", trainerInfo);
		
		user.setName(trainer.getName());
		user.setContact(trainer.getContact());
		user.setAddress(trainer.getAddress());
		user.setBirthday(trainer.getBirthday());
	}
	
	
	
	
	
}
