package com.jaspa.healthtouch.trainer.trainerInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void selectTrainerInfo() {}
	
	@PostMapping("/trainer-info")
	public void selectTrainerInfo(TrainerMemberDTO trainer, TrainerServiceImpl info) {
		
		List<TrainerMemberDTO> trainerInfo = (List<TrainerMemberDTO>) trainerService.selectTrainer();
		trainerService.updateTrainer(trainer);
		
		trainer.setName(trainer.getName());
		trainer.setContact(trainer.getContact());
		trainer.setAddress(trainer.getAddress());
		trainer.setBirthday(trainer.getBirthday());
		trainer.setCareer(trainer.getCareer());
	}
	
	
	
	
	
}
