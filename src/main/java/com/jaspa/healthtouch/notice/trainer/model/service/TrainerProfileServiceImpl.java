package com.jaspa.healthtouch.notice.trainer.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;
import com.jaspa.healthtouch.notice.trainer.model.dao.TrainerProfileMapper;

@Service
@Transactional
public class TrainerProfileServiceImpl implements TrainerProfileService {
	private TrainerProfileMapper trainerProfileMapper;
	
	//트레이너 후기 조회(서현승)
	@Override
	public ReviewDTO trainerProfile(int no, String memberId){
		return trainerProfileMapper.trainerProfile(no, memberId);
	}
	
	//트레이너 후기 조회(남지현)
	@Override
	public ReviewDTO trainerProfile1(int no, String memberId){
		return trainerProfileMapper.trainerProfile1(no, memberId);
	}
	
	//트레이너 후기 조회(허승준)
	@Override
	public ReviewDTO trainerProfile2(int no, String memberId){
		return trainerProfileMapper.trainerProfile2(no, memberId);
	}
	
	//트레이너 후기 조회(한주은)
	@Override
	public ReviewDTO trainerProfile3(int no, String memberId){
		return trainerProfileMapper.trainerProfile3(no, memberId);
	}
}
