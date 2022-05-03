package com.jaspa.healthtouch.center.tr_management.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaspa.healthtouch.login.model.dto.MemberDTO;

@Mapper
public interface TrainerMapper {

	List<MemberDTO> selectAllTrainer();

}
