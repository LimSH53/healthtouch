package com.jaspa.healthtouch.center.tr_management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.tr_management.model.dao.TrainerMapper;
import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;

@Service("trManagementService")
@Transactional
public class TrManagementServiceImpl implements TrManagementService{

	private TrainerMapper trainerMapper;
	
	@Autowired
	public void TrManagementServiceImpl(TrainerMapper trainerMapper) {
		this.trainerMapper = trainerMapper;
	}
	
	 
	@Override
	public List<TrainerInfoDTO> selectAllTrainer() {
		return trainerMapper.selectAllTrainer();
	}


	@Override
	public TrainerInfoDTO trainerDetail(String trId) {
		
		return trainerMapper.detailTrainerById(trId);
	}

	@Transactional
	@Override
	public void deleteTrainer(String id) {
		trainerMapper.deleteTrainer(id);
		
	}


	


	
	
}
