package com.jaspa.healthtouch.trainer.schedule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
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
	
	
	
	@RequestMapping(value = "/allschedule", method = RequestMethod.GET)
	@ResponseBody
	@GetMapping("/allschedule")
	public Map<String, TrainerScheduleDTO> selectTrainerSchedule(@AuthenticationPrincipal UserImpl user) {
		
		Map<String, TrainerScheduleDTO> schedule = new HashMap<>();
		
		user.setId(user.getId());
		List<TrainerScheduleDTO> scheduleList = trainerScheduleService.selectTrainerSchedule(user.getId());
		
		log.info("트레이너 스케줄 정보 :{}", scheduleList.toString());	
		
		return schedule;
	}

	
	
	
	
	
	@RequestMapping(value = "/addschedule", method = RequestMethod.POST)
	@ResponseBody
	public String insertSchedule(@RequestBody TrainerScheduleDTO schedule, @AuthenticationPrincipal UserImpl user) {
		
		schedule.setId(user.getId());
		trainerScheduleService.insertSchedule(schedule);
		
		log.info("Controller schedule :{}", schedule);
		
		return "스케줄 등록에 성공하였습니다.";
	}
	
	
	
	
	
	
	
}
