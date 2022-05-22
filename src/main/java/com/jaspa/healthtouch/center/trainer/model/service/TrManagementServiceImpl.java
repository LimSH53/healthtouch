package com.jaspa.healthtouch.center.trainer.model.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaspa.healthtouch.center.trainer.model.dao.TrainerMapper;
import com.jaspa.healthtouch.center.trainer.model.dto.AttendanceDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.HolidayDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerInfoDTO;
import com.jaspa.healthtouch.center.trainer.model.dto.TrainerSalaryDTO;
import com.jaspa.healthtouch.common.paging.Criteria;
import com.jaspa.healthtouch.common.paging.PaginationInfo;
import com.jaspa.healthtouch.login.model.dto.MemberDTO;

@Service("trManagementService")
public class TrManagementServiceImpl implements TrManagementService {

	private TrainerMapper trainerMapper;

	@Autowired
	public void TrManagementServiceImpl(TrainerMapper trainerMapper) {
		this.trainerMapper = trainerMapper;
	}

	@Override
	public List<TrainerInfoDTO> selectAllTrainer(TrainerInfoDTO params) {
		
		  List<TrainerInfoDTO> trainerList = Collections.emptyList();
		 
		  int trainerTotalCount = trainerMapper.selectAllTrainerTotalCount(params);
		  
		  PaginationInfo paginationInfo = new PaginationInfo(params);
		  paginationInfo.setTotalRecordCount(trainerTotalCount);
		  
		  params.setPaginationInfo(paginationInfo);
		  
		  if(trainerTotalCount > 0) { 
			  trainerList = trainerMapper.selectAllTrainer(params); 
			  }
		  
		  return trainerList; 
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

	@Override
	public List<TrainerSalaryDTO> selectAllSalary() {
	
		return trainerMapper.selectAllSalary();
	}

	
	@Override
	public List<HolidayDTO> selectAllHdayRequest(HolidayDTO params) {
		  
		  List<HolidayDTO> hdayRequestList = Collections.emptyList();
		 
		  int holidayTotalCount = trainerMapper.selectAllHolidayTotalCount(params);
		  
		  PaginationInfo paginationInfo = new PaginationInfo(params);
		  paginationInfo.setTotalRecordCount(holidayTotalCount);
		  
		  params.setPaginationInfo(paginationInfo);
		  
		  if(holidayTotalCount > 0) { 
			  hdayRequestList = trainerMapper.selectAllHodlidayRequest(params); 
			  }
		  
		  return hdayRequestList; 
	}
	
	@Override
	public void approvalHoliday(String id) {
		trainerMapper.approvalHoliday(id);
		
	}

	@Override
	public List<AttendanceDTO> selectAllAttendanceList() {
		
		return trainerMapper.selectAllAttendance();
	}

	

	

	



	



}
