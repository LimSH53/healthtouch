package com.jaspa.healthtouch.trainer.schedule.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.trainer.schedule.model.dao.TrainerScheduleMapper;
import com.jaspa.healthtouch.trainer.schedule.model.dto.TrainerScheduleDTO;


@Service("trainerScheduleService")
@Transactional
public class TrainerScheduleServiceImpl implements TrainerScheduleService{

	private TrainerScheduleMapper trainerScheduleMapper;
	
	@Autowired
	public TrainerScheduleServiceImpl(TrainerScheduleMapper trainerScheduleMapper) {
		this.trainerScheduleMapper = trainerScheduleMapper;
	}
	
	
	@Override
	public TrainerScheduleDTO selectTrainerSchedule(String id) {
		return trainerScheduleMapper.selectTrainerSchedule(id);
	}

}
