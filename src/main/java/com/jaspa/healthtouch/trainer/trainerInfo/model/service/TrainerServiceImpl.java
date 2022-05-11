package com.jaspa.healthtouch.trainer.trainerInfo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.trainer.trainerInfo.model.dao.TrainerInfoMapper;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;

@Service
public class TrainerServiceImpl implements TrainerService{

	private TrainerInfoMapper trainerInfoMapper;
	
	
	@Autowired
	public void TrainerServiceImpl(TrainerInfoMapper trainerInfoMapper) {
		this.trainerInfoMapper = trainerInfoMapper;
	}

	@Override
	public List<TrainerMemberDTO> selectTrainer() {
		return (List<TrainerMemberDTO>) trainerInfoMapper.selectTrainer();
	}

	@Transactional
	@Override
	public void updateTrainer(TrainerMemberDTO trainer) {
		trainerInfoMapper.updateTrainer(trainer);
		
	}


}
