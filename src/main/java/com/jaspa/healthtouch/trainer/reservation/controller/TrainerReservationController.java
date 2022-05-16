package com.jaspa.healthtouch.trainer.reservation.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaspa.healthtouch.common.model.dto.FullCalendarDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.trainer.reservation.model.service.TrainerReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/trainer/reservation")
public class TrainerReservationController {
	private TrainerReservationService trainerReservationService;
	
	@Autowired
	public TrainerReservationController(TrainerReservationService trainerReservationService) {
		this.trainerReservationService = trainerReservationService;
	}
	
	@GetMapping("/calendar")
	public void calendar() {}
	
	@PostMapping("/calendar")
	@ResponseBody
	public Map<String, FullCalendarDTO> calendar(@AuthenticationPrincipal UserImpl user) {
		Map<String, FullCalendarDTO> rsvMap = new HashMap<>();
		List<ReservationDTO> reservationList = trainerReservationService.findReservationById(user.getId());
		
		for(int i = 0; i < reservationList.size(); i++) {
			ReservationDTO reservation = reservationList.get(i);
			
			String title = reservation.getMember().getName() + " 회원님";
			Date start = reservation.getDatetime();
			
			rsvMap.put("event" + i, new FullCalendarDTO(title, start, false));
		}
		
		return rsvMap;
	}
	
	@GetMapping("/reservationList")
	public String reservationList(@ModelAttribute("params") ReservationDTO params, Model model, @AuthenticationPrincipal UserImpl user) {
		params.setMemberId(user.getId());
		List<ReservationDTO> reservationList = trainerReservationService.findAllReservation(params);
		
		model.addAttribute("reservationList", reservationList);
		
		return "trainer/reservation/reservationList";
	}
	
	@PostMapping("/detail")
	@ResponseBody
	public Object getDetail(@RequestParam("reservationNo") int no) {
		ReservationChangeDTO reservationChange = trainerReservationService.getChangeDetail(no);
		
		if(reservationChange != null) {
			return reservationChange;
		} else {
			return trainerReservationService.getDetail(no);
		}
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public void cancelReservation(@RequestParam("reservationNo") String reservationNo) {
		trainerReservationService.cancelReservation(reservationNo);
	}
	
	@PostMapping("/cancelAll")
	@ResponseBody
	public void cancelAllReservation(@RequestParam("reservationNo") String reservationNo) {
		trainerReservationService.cancelAllReservation(reservationNo);
	}
	
	@PostMapping("acceptReservation")
	@ResponseBody
	public void acceptReservation(@RequestParam("reservationNo") String reservationNo) {
		trainerReservationService.acceptReservation(reservationNo);
	}
	
	@PostMapping("/acceptReservationChange")
	@ResponseBody
	public void acceptReservationChange(@RequestParam("reservationNo") String reservationNo, @RequestParam("reservationChangeNo") String reservationChangeNo) {
		// 요청한 예약 변경일 
		Date datetime = trainerReservationService.findReservationChangeDatetime(reservationChangeNo);
		trainerReservationService.acceptReservationChange(reservationNo, reservationChangeNo, datetime);
	}
}
