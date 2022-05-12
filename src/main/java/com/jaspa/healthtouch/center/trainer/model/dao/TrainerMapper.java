package com.jaspa.healthtouch.center.trainer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;

@Mapper
public interface TrainerMapper {
 


	List<TrainerInfoDTO> selectAllTrainer();


	TrainerInfoDTO detailTrainerById(String trId);


	void deleteTrainer(String id);


	void deleteTrainerMStatus(String id);



	

}
