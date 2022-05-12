package com.jaspa.healthtouch.trainer.trainerInfo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;
import com.jaspa.healthtouch.trainer.trainerInfo.model.dto.TrainerMemberDTO;

@Mapper
public interface TrainerInfoMapper {

	// 트레이너 정보 조회
	TrainerMemberDTO selectTrainer(String id);
	
	// 트레이너 정보 수정
	int updateTrainer(TrainerMemberDTO trainer);
	
	// 트레이너 정보 수정2
	int updateTrainerInfo(TrainerMemberDTO trainer);
}
