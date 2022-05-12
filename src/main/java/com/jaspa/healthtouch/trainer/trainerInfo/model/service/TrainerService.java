package com.jaspa.healthtouch.trainer.trainerInfo.model.service;

import java.util.List;

import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;


public interface TrainerService {

	
	/* 회원정보 - 조회 */
	TrainerMemberDTO selectTrainer(String id);
	
	void updateTrainer(TrainerMemberDTO trainer);
	
}
