package com.jaspa.healthtouch.trainer.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
