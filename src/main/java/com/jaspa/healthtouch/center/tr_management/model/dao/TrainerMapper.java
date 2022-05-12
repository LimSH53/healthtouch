package com.jaspa.healthtouch.center.tr_management.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.tr_management.model.dto.TrainerInfoDTO;

@Mapper
public interface TrainerMapper {
 


	List<TrainerInfoDTO> selectAllTrainer();


	TrainerInfoDTO detailTrainerById(String trId);


	void deleteTrainer(String id);


	void deleteTrainerMStatus(String id);

	

}
