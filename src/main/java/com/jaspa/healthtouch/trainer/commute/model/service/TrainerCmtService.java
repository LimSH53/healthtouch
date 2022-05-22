package com.jaspa.healthtouch.trainer.commute.model.service;

import java.util.List;

import com.jaspa.healthtouch.trainer.commute.model.dto.TrainerCmtDTO;

public interface TrainerCmtService {

	
	// 트레이너 근태 조회
	List<TrainerCmtDTO> selectTrainerCmt(String id);
	
	// 트레이너 근태 삽입
	void insertTrainerCmt(TrainerCmtDTO cmt);
	
}
