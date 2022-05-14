package com.jaspa.healthtouch.center.trainer.model.service;

import java.util.List;

import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.common.paging.Criteria;

public interface TrManagementService {

	List<TrainerInfoDTO> selectAllTrainer();

	TrainerInfoDTO trainerDetail(String trId);

	void deleteTrainer(String id);

	List<TrainerSalaryDTO> selectAllSalary();

	List<HolidayDTO> selectAllHdayRequest();

//	List<TrainerInfoDTO> searchTrainer(TrainerInfoDTO params, Criteria criteria); 

	

	

  
} 
