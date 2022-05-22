package com.jaspa.healthtouch.trainer.commute.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.trainer.commute.model.dto.TrainerCmtDTO;
import com.jaspa.healthtouch.trainer.commute.model.service.TrainerCmtService;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer/cmt")
public class TrainerCmtController {

	private TrainerCmtService trainerCmtService;
		
	
		public TrainerCmtController(TrainerCmtService trainerCmtService) {
			this.trainerCmtService = trainerCmtService;
		}
		
		
		
		
		
		@ResponseBody
		@GetMapping("/all")
		public ModelAndView selectTrainerCmt(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
			
			user.setId(user.getId());
		//	List<TrainerScheduleDTO> scheduleList = trainerScheduleService.selectTrainerSchedule(user.getId());
			
		//	log.info("트레이너 스케줄 정보 :{}", scheduleList.toString());	
			
		//	mv.addObject("scheduleList", scheduleList);
			mv.setViewName("trainer/trainer-cmt");
			
			return mv;
		}
		
		
		
		
		

		@RequestMapping(value = "/add", method = RequestMethod.POST)
		@ResponseBody
		public String insertTrainerCmt(@RequestBody TrainerCmtDTO cmt, @AuthenticationPrincipal UserImpl user) {
			
			cmt.setId(user.getId());
			trainerCmtService.insertTrainerCmt(cmt);
			
			log.info("Controller cmt :{}", cmt);
			
			return "근태 등록에 성공하였습니다.";
		}
		
		
		
		
		
		
		
		
	}
