package com.jaspa.healthtouch.center.trainer.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.jaspa.healthtouch.common.model.dto.FullCalendarDTO;

import lombok.extern.slf4j.Slf4j;

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
	public String hdayRequestList(Model model, @ModelAttribute("params") HolidayDTO params) {
		
		List<HolidayDTO> hdayRequestList = trManagementService.selectAllHdayRequest(params);
		
		model.addAttribute("hdayRequestList", hdayRequestList);
		
		return "center/trainer/hdayRequestList";
	}
	
	//휴가 승인
	@RequestMapping("/hday/approval")
	@ResponseBody
	public void approvalHoliday(@RequestParam("trId") String id) {
		trManagementService.approvalHoliday(id);
	}
	
	//휴가 반려
	@RequestMapping("/hday/reject")
	@ResponseBody
	public void rejectHoliday(@RequestParam("trId") String id) {
		trManagementService.rejectHoliday(id);
	}
	
	//휴가 캘린터
	@GetMapping("/hday/calendar")
	public void holidayCalendar() {}
		

	@PostMapping("/hday/calendar")
	@ResponseBody
	public Map<String, FullCalendarDTO> holidayCalen() {
		Map<String, FullCalendarDTO> hdayMap = new HashMap<>();
		List<HolidayDTO> holidayList = trManagementService.findAllHoliday();
		
		for(int i = 0; i < holidayList.size(); i++) {
			HolidayDTO holiday = holidayList.get(i);
			String title = holiday.getTrainer().getMember().getName();
			Date hDay = holiday.getHDay();
			
			hdayMap.put("event" + i, new FullCalendarDTO(title, hDay, true ));
		}
		
		return hdayMap;
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