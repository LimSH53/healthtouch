package com.jaspa.healthtouch.notice.trainer.model.dao;




import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.member.product.model.dto.ReviewDTO;
@Mapper
public interface TrainerProfileMapper {


	//트레이너 후기 조회(서현승)
	ReviewDTO trainerprofile();


}