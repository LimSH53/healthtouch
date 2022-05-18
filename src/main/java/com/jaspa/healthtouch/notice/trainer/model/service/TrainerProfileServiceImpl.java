package com.jaspa.healthtouch.notice.trainer.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;
import com.jaspa.healthtouch.notice.trainer.model.dao.TrainerProfileMapper;

@Service
public class TrainerProfileServiceImpl implements TrainerProfileService {
	private TrainerProfileMapper trainerProfileMapper;
	
	//트레이너 후기 조회(서현승)
	@Override
	public ReviewDTO trainerprofile(){
		return trainerProfileMapper.trainerprofile();
	}
}
