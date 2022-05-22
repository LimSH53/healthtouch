package com.jaspa.healthtouch.trainer.commute.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.trainer.commute.model.dao.TrainerCmtMapper;
import com.jaspa.healthtouch.trainer.commute.model.dto.TrainerCmtDTO;

@Service
@Transactional
public class TrainerCmtServiceImpl implements TrainerCmtService{

	private final TrainerCmtMapper trainerCmtMapper;
	
	@Autowired
	public TrainerCmtServiceImpl(TrainerCmtMapper trainerCmtMapper) {
		this.trainerCmtMapper = trainerCmtMapper;
	}
	
	
	
	
	
	@Override
	public List<TrainerCmtDTO> selectTrainerCmt(String id) {		
		return trainerCmtMapper.selectTrainerCmt(id);
	}

	@Override
	public void insertTrainerCmt(TrainerCmtDTO cmt) {
		trainerCmtMapper.insertTrainerCmt(cmt);
		System.out.println("근태impl : " + cmt);
		
	}

}
