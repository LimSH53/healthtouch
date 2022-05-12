package com.jaspa.healthtouch.center.trainer.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.trainer.model.dao.TrainerMapper;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.common.paging.PaginationInfo;

@Service("trManagementService")
@Transactional
public class TrManagementServiceImpl implements TrManagementService{

	private TrainerMapper trainerMapper;
	
	@Autowired
	public void TrManagementServiceImpl(TrainerMapper trainerMapper) {
		this.trainerMapper = trainerMapper;
	}
	
	 
	@Override
	public List<TrainerInfoDTO> selectAllTrainer() {
		return trainerMapper.selectAllTrainer();
	}


	@Override
	public TrainerInfoDTO trainerDetail(String trId) {
		
		return trainerMapper.detailTrainerById(trId);
	}

	@Transactional
	@Override
	public void deleteTrainer(String id) {
		trainerMapper.deleteTrainer(id);
		trainerMapper.deleteTrainerMStatus(id);
		
	}

	/*
	 * @Override public List<TrainerInfoDTO> searchTrainer(TrainerInfoDTO params) {
	 * 
	 * List<TrainerInfoDTO> trSearchList = Collections.emptyList();
	 * 
	 * int trainerTotalCount = trainerMapper.searchTrainerTotalCount(params);
	 * 
	 * PaginationInfo paginationInfo = new PaginationInfo(params);
	 * paginationInfo.setTotalRecordCounttrainerTotalCount);
	 * 
	 * params.setPaginationInfo(paginationInfo);
	 * 
	 * if(trainerTotalCount > 0) { trSearchList =
	 * trainerMapper.searchTrainer(params); }
	 * 
	 * return trSearchList; }
	 */


	


	
	
}
