package com.jaspa.healthtouch.trainer.schedule.model.service;

import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;



public interface TrainerScheduleService {

	/* 회원정보 - 조회 */
	TrainerScheduleDTO selectTrainerSchedule(String id);
	
	
	
}
