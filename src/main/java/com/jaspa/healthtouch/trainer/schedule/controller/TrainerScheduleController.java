package com.jaspa.healthtouch.trainer.schedule.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;
import com.jaspa.healthtouch.trainer.schedule.model.service.TrainerScheduleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer/schedule")
public class TrainerScheduleController {

	private TrainerScheduleService trainerScheduleService;
	
	public TrainerScheduleController(TrainerScheduleService trainerScheduleService) {
		this.trainerScheduleService = trainerScheduleService;
	}
	
	
	

	@GetMapping("/allschedule")
	public ModelAndView selectTrainerSchedule(TrainerScheduleDTO schedule, ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		schedule.setId(user.getId());
		List<TrainerScheduleDTO> trainerSch = trainerScheduleService.selectTrainerSchedule(user.getId());
		
		log.info("트레이너 정보 :{}", trainerSch.toString());
		
		mv.addObject("trainerSch", trainerSch);
		mv.setViewName("trainer/trainer-schedule");
		
		
		return mv;
	}

	
	
	
	
	
	@RequestMapping(value = "/addschedule", method = RequestMethod.POST)
	@ResponseBody
	public String insertSchedule(@RequestBody TrainerScheduleDTO schedule, @AuthenticationPrincipal UserImpl user) {
		
		schedule.setId(user.getId());
		String id = String.valueOf(user.getId());
		trainerScheduleService.insertSchedule(id);
		
		log.info("schedule :{}", schedule);
		
		return "스케줄 등록에 성공하였습니다.";
	}
	
	
	
	
	
	
	
}
