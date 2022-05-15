package com.jaspa.healthtouch.member.reservation.controller;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaspa.healthtouch.common.model.dto.FullCalendarDTO;
import com.jaspa.healthtouch.login.model.dto.UserImpl;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationChangeDTO;
import com.jaspa.healthtouch.member.reservation.model.dto.ReservationDTO;
import com.jaspa.healthtouch.member.reservation.model.service.MemberReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/reservation")
public class MemberReservationController {
	private MemberReservationService memberReservationService;
	
	@Autowired
	public MemberReservationController(MemberReservationService memberReservationService) {
		this.memberReservationService = memberReservationService;
	}
	
	@GetMapping("/calendar")
	public void calendar() {}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/calendar")
	@ResponseBody
	public Map<String, FullCalendarDTO> calendar(@AuthenticationPrincipal UserImpl user) throws JsonProcessingException {
		Map<String, FullCalendarDTO> rsvMap = new HashMap<>();
		List<ReservationDTO> reservationList = memberReservationService.findReservationById(user.getId());
		
		for(int i = 0; i < reservationList.size(); i++) {
			ReservationDTO reservation = reservationList.get(i);
			String title = "PT";
			Date start = reservation.getDatetime();
			
			rsvMap.put("event" + i, new FullCalendarDTO(title, start, false));
		}
		
		return rsvMap;
	}
	
	@GetMapping("/reservationList")
	public String reservationList(@ModelAttribute("params") ReservationDTO params, Model model, @AuthenticationPrincipal UserImpl user) {
		params.setMemberId(user.getId());
		List<ReservationDTO> reservationList = memberReservationService.findAllReservation(params);
		
		model.addAttribute("reservationList", reservationList);
		
		return "member/reservation/reservationList";
	}
	
	@PostMapping("/detail")
	@ResponseBody
	public Object getDetail(@RequestParam("reservationNo") int no) {
		ReservationChangeDTO reservationChange = memberReservationService.getChangeDetail(no);
		
		if(reservationChange != null) {
			return reservationChange;
		} else {
			return memberReservationService.getDetail(no);
		}
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public void cancelReservation(@RequestParam("reservationNo") String reservationNo) {
		memberReservationService.cancelReservation(reservationNo);
	}
	
	@PostMapping("/cancelChange")
	@ResponseBody
	public void cancelReservationChange(@RequestParam("reservationChangeNo") String reservationChangeNo) {
		memberReservationService.cancelReservationChange(reservationChangeNo);
	}
}
