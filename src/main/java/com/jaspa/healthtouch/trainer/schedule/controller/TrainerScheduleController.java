package com.jaspa.healthtouch.trainer.schedule.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;
import com.jaspa.healthtouch.trainer.schedule.model.service.TrainerScheduleService;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer/schedule")
public class TrainerScheduleController {

	private TrainerScheduleService trainerScheduleService;
	
	public TrainerScheduleController(TrainerScheduleService TrainerScheduleService) {
		this.trainerScheduleService = trainerScheduleService;
	}
	
	
	
	@GetMapping("/allschedule")
	public ModelAndView selectTrainerSchedule(TrainerScheduleDTO schedule, ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		schedule.setId(user.getId());
		TrainerScheduleDTO trainerSch = trainerScheduleService.selectTrainerSchedule(user.getId());
		
		log.info(trainerSch.toString());
		
		mv.addObject("trainerSch", trainerSch);
		mv.setViewName("trainer/trainer-schedule");
		
		
		return mv;
	}
	
	
	
	

	/*
	@PostMapping("/schedule")
	public void selectTrainerSchedule(TrainerScheduleDTO schedule,  @AuthenticationPrincipal UserImpl user, Model model) {
		
		schedule.setSchId(user.getId());
		log.info(schedule.toString());
		trainerScheduleService.selectTrainerSchedule(schedule);
		
		TrainerMemberDTO trainerInfo = trainerScheduleService.selectTrainerSchedule(user.getId());
		model.addAttribute("trainerInfo", trainerInfo);
		
	}
	
	*/
	
	
	
	
	
	
	
}
