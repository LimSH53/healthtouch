package com.jaspa.healthtouch.center.trainer.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;

public interface TrManagementService {

	List<TrainerInfoDTO> selectAllTrainer();

	TrainerInfoDTO trainerDetail(String trId);

	void deleteTrainer(String id);

	/* List<TrainerInfoDTO> searchTrainer(TrainerInfoDTO params); */

	

	

  
} 
