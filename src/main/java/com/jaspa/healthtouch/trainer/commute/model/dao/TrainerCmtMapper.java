package com.jaspa.healthtouch.trainer.commute.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.trainer.commute.model.dto.TrainerCmtDTO;

@Mapper
public interface TrainerCmtMapper {

	
		// 트레이너 근태 조회
		List<TrainerCmtDTO> selectTrainerCmt(String id);
		
		// 트레이너 근태 삽입
		void insertTrainerCmt(TrainerCmtDTO cmt);
	
	
	
}
