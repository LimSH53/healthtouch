package com.jaspa.healthtouch.trainer.schedule.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

@Mapper
public interface TrainerScheduleMapper {

	
	// 트레이너 스케줄 조회
	List<TrainerScheduleDTO> selectTrainerSchedule(String id);
	
	// 트레이너 스케줄 삽입
	void insertSchedule(String id);
	
}
