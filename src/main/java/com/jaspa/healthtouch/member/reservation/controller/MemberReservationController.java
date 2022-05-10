package com.jaspa.healthtouch.member.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
