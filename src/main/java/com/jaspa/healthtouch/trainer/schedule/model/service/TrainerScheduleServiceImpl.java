package com.jaspa.healthtouch.trainer.schedule.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.trainer.schedule.model.dao.TrainerScheduleMapper;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class TrainerScheduleServiceImpl implements TrainerScheduleService{

	private final TrainerScheduleMapper trainerScheduleMapper;
	
	@Autowired
	public TrainerScheduleServiceImpl(TrainerScheduleMapper trainerScheduleMapper) {
		this.trainerScheduleMapper = trainerScheduleMapper;
	}
	
	
	
	@Override
	public List<TrainerScheduleDTO> selectTrainerSchedule(String id) {
		return trainerScheduleMapper.selectTrainerSchedule(id);
	}

	@Override
	public void insertSchedule(TrainerScheduleDTO schedule) {
		trainerScheduleMapper.insertSchedule(schedule);
		System.out.println("서비스impl : " + schedule);
	}

}
