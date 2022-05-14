package com.jaspa.healthtouch.center.trainer.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.common.paging.Criteria;

@Mapper
public interface TrainerMapper {
 


	List<TrainerInfoDTO> selectAllTrainer();


	TrainerInfoDTO detailTrainerById(String trId);


	void deleteTrainer(String id);


	void deleteTrainerMStatus(String id);


	int searchTrainerTotalCount(Criteria criteria);


	List<TrainerInfoDTO> searchTrainer(Criteria criteria);


	List<TrainerSalaryDTO> selectAllSalary();


	List<HolidayDTO> selectAllHdayRequest();



	

}
