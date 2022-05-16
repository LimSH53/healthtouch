package com.jaspa.healthtouch.trainer.schedule.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;

@Mapper
public interface TrainerScheduleMapper {

	
	// 트레이너 스케줄 조회
	TrainerScheduleDTO selectTrainerSchedule(String id);
	
	
	
	
}
