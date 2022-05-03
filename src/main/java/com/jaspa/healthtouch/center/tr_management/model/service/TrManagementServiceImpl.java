package com.jaspa.healthtouch.center.tr_management.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.tr_management.model.dao.TrainerMapper;
import com.jaspa.healthtouch.login.model.dao.MemberMapper;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

@Service("trManagementService")
@Transactional
public class TrManagementServiceImpl implements TrManagementService{

	private TrainerMapper trainerMapper;
	
	@Autowired
	public void TrManagementServiceImpl(TrainerMapper trainerMapper) {
		this.trainerMapper = trainerMapper;
	}
	
	
	@Override
	public List<MemberDTO> selectAllTrainer() {
		return trainerMapper.selectAllTrainer();
	}

}
