package com.jaspa.healthtouch.trainer.schedule.model.service;

import java.util.List;

import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;



public interface TrainerScheduleService {

	/* 회원정보 - 조회 */
	List<TrainerScheduleDTO> selectTrainerSchedule(String id);
	
	/* 트레이너 스케줄 삽입 */
	void insertSchedule(String id);
}
