package com.jaspa.healthtouch.notice.trainer.model.service;


import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;


public interface TrainerProfileService {

	//트레이너 후기 조회(서현승)
	ReviewDTO trainerProfile(int no, String memberId);

	//트레이너 후기 조회(남지현)
	ReviewDTO trainerProfile1(int no, String memberId);

	//트레이너 후기 조회(허승준)
	ReviewDTO trainerProfile2(int no, String memberId);

	//트레이너 후기 조회(박단단)
	ReviewDTO trainerProfile3(int no, String memberId);


}
