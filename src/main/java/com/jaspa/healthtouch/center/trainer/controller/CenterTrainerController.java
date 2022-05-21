package com.jaspa.healthtouch.center.trainer.controller;

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

import com.jaspa.healthtouch.center.trainer.model.dto.AttendanceDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.center.trainer.model.service.TrManagementService;

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
	
	//트레이너 목록 조회
	@GetMapping("/list")
	public String trainerList(Model model, @ModelAttribute("params") TrainerInfoDTO params) {
		List<TrainerInfoDTO> trainerList = trManagementService.selectAllTrainer(params);
		
		model.addAttribute("trainerList", trainerList);
		
		return "center/trainer/trainerList";
	}

	
	//트레이너 상세조회
	@GetMapping("/detail")
	public String trainerDetail(@ModelAttribute("params") TrainerInfoDTO params, @RequestParam("id") String id, Model model) {
		
		TrainerInfoDTO trainer = trManagementService.trainerDetail(id);
		
		model.addAttribute("trainer",trainer);
		
		return "center/trainer/trainerDetail";
	}
	
	//트레이너 퇴사
	@PostMapping("/delete")
	@ResponseBody
	public void deleteTrainer(@RequestParam("trId") String id) {
		trManagementService.deleteTrainer(id);
	}
	
	//급여 리스트 조회
	@GetMapping("/salary")
	public ModelAndView selectAllSalary(ModelAndView mv) {
		
		List<TrainerSalaryDTO> salaryList = trManagementService.selectAllSalary();
		
		mv.addObject("salaryList", salaryList);
		mv.setViewName("center/trainer/salaryList");
		return mv;
	}
	
	//휴가요청 조회
	@GetMapping("/hday")
	public ModelAndView selectAllHdayRequest(ModelAndView mv) {
		
		List<HolidayDTO> hdayRequestList = trManagementService.selectAllHdayRequest();
		
		mv.addObject("hdayRequestList", hdayRequestList);
		mv.setViewName("center/trainer/hdayRequestList");
		return mv;
	}
	
	// 근태 조회
	@GetMapping("/attendance")
	public ModelAndView selectAllAttendanceList(ModelAndView mv) {
		
		List<AttendanceDTO> attendanceList = trManagementService.selectAllAttendanceList();
		
		mv.addObject("attendanceList", attendanceList);
		mv.setViewName("center/trainer/attendanceList");
		return mv;
	}
	
}